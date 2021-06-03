package java_io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIOServer
 *
 * @author lijunsong
 * @date 2021/5/25 17:52
 * @since 1.0
 */
@Slf4j
public class NIOServer {
    @SneakyThrows
    public static void main(String[] args) {
        Selector selector = Selector.open();

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9090);
        serverSocket.bind(address);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                    /**
                     * 服务器为每个连接创建一个SocketChannel
                     */
                    SocketChannel socketChannel = ssChannel1.accept();
                    socketChannel.configureBlocking(false);
                    /**
                     * 这个新连接主要用于客户端读取数据
                     */
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    log.info(readDataFromSocketChannel(socketChannel));
                    socketChannel.close();
                }
                iterator.remove();
            }
        }
    }

    @SneakyThrows
    private static String readDataFromSocketChannel(SocketChannel socketChannel) {
        StringBuilder data = new StringBuilder();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            int n = socketChannel.read(buffer);

            //EOF
            if (n == -1) {
                break;
            }

            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
}
