package java_io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * CopyFile
 * 字节操作：InputStream 和 OutputStream
 *
 * @author lijunsong
 * @date 2021/5/25 14:19
 * @since 1.0
 */
@Slf4j
public class CopyFile {
    @SneakyThrows
    public static void copyFile(String src, String dist) {
        FileInputStream fin = new FileInputStream(src);
        FileOutputStream fout = new FileOutputStream(dist);

        int count;
        byte[] buffer = new byte[20 * 1024];
        /**
         * read() 最多读取 buffer.length 个字节
         * 返回的是实际读取的个数
         * 返回 -1 的时候表示读到 eof，即文件尾
         */
        while ((count = fin.read(buffer, 0, buffer.length)) != -1) {
            fout.write(buffer, 0, count);
        }
        fin.close();
        fout.close();
    }

    public static void main(String[] args) {
        Long time1 = System.currentTimeMillis();
        copyFile("D:\\download\\解压密码.png",
                String.format("D:\\download\\解压密码%s.png", new Random().nextInt(100)));
        Long time2 = System.currentTimeMillis();
        log.info("耗时：{}ms", (time2 - time1));
    }
}
