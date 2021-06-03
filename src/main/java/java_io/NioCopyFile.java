package java_io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * NioCopyFile
 *
 * @author lijunsong
 * @date 2021/5/25 17:34
 * @since 1.0
 */
@Slf4j
public class NioCopyFile {
    @SneakyThrows
    public static void fastCopy(String src, String target) {
        /**
         * 文件的输入字节流
         */
        FileInputStream fin = new FileInputStream(src);
        /**
         * 获取输入字节流的文件Channel
         */
        FileChannel fileChannel = fin.getChannel();
        /**
         * 目标文件的输出字节流
         */
        FileOutputStream fout = new FileOutputStream(target);

        /**
         * 获取输出字节流的文件Channel
         */
        FileChannel fileChannelOut = fout.getChannel();
        /**
         * 缓冲区
         */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            /**
             * 从输入channel中读取数据到buffer中
             */
            int r = fileChannel.read(buffer);

            /**
             * read() 返回-1表示文件结尾
             */
            if (r == -1) {
                break;
            }

            /**
             * 切换读写
             */
            buffer.flip();

            /**
             * 把缓冲区的内容写入输出文件中
             */
            fileChannelOut.write(buffer);

            /**
             * 清空缓冲区
             */
            buffer.clear();
        }
    }

    public static void main(String[] args) {
        Long time1 = System.currentTimeMillis();
        fastCopy("D:\\download\\解压密码.png",
                String.format("D:\\download\\解压密码%s.png", new Random().nextInt(100)));
        Long time2 = System.currentTimeMillis();
        log.info("耗时：{}ms", (time2 - time1));
    }
}
