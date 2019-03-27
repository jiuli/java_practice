package effectivejava.CH3.javatuning.ch3.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO(New I/O的简称)
 * NIO是基于块，缓冲Buffer是一块连续的内存块，是NIO的读写数据的中转地。
 * Channel是缓冲数据的源头或目的地，它用于读取或写入数据，是访问缓冲的接口。
 *
 * @author lijunsong
 * @date 2019/3/25 16:27
 * @since 1.0
 */
public class TestByteBuffer {
    public static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(resource);

        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        //读取文件通道Channel
        FileChannel readChannel = fileInputStream.getChannel();
        //写文件通道Channel
        FileChannel writeChannel = fileOutputStream.getChannel();
        //读入数据缓冲
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            //读入数据
            int len = readChannel.read(byteBuffer);
            if (len == -1) {
                //读取完毕
                break;
            }
            byteBuffer.flip();
            //写入文件
            writeChannel.write(byteBuffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    /**
     * Buffer三个重要的参数：位置Position,容量（Capacity）和上限（Limit）
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //15个子节大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        System.out.println("limit = " + byteBuffer.limit() + ",capacity = " + byteBuffer.capacity() + ",position = " +
                byteBuffer.position());
        //存入10个子节数据
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("limit = " + byteBuffer.limit() + ",capacity = " + byteBuffer.capacity() + ",position = " +
                byteBuffer.position());
        //重置position
        byteBuffer.flip();
        System.out.println("limit = " + byteBuffer.limit() + ",capacity = " + byteBuffer.capacity() + ",position = " +
                byteBuffer.position());

        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer.get());
        }
        System.out.println("limit = " + byteBuffer.limit() + ",capacity = " + byteBuffer.capacity() + ",position = " +
                byteBuffer.position());
        //重置position
        byteBuffer.flip();
        System.out.println("limit = " + byteBuffer.limit() + ",capacity = " + byteBuffer.capacity() + ",position = " +
                byteBuffer.position());



        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(new File("javatuning\\ch3\\说明.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer1);
        fileChannel.close();
        byteBuffer1.flip();
    }
}
