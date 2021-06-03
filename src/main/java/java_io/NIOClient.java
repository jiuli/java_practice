package java_io;

import lombok.SneakyThrows;

import java.io.OutputStream;
import java.net.Socket;

/**
 * NIOClient
 *
 * @author lijunsong
 * @date 2021/5/25 18:05
 * @since 1.0
 */
public class NIOClient {
    /**
     * 先启动NIOServer,再启动NIOClient
     */
    @SneakyThrows
    public static void main(String[] args) {
        Socket socket = new Socket("127.0.0.1", 9090);
        OutputStream out = socket.getOutputStream();
        String s = "hello world1";
        out.write(s.getBytes());
        out.close();
    }

}
