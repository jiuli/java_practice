package java_io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * ReadFile
 * 字符操作：Reader 和 Writer
 *
 * @author lijunsong
 * @date 2021/5/25 14:32
 * @since 1.0
 */
@Slf4j
public class ReadFile {
    @SneakyThrows
    public static void readFileContent(String filePath) {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            log.info(line);
        }
        /**
         * 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
         * 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
         * 因此只要一个 close() 调用即可
         */
        br.close();
    }

    /**
     * 不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符。
     * 但是在程序中操作的通常是字符形式的数据，因此需要提供对字符进行操作的方法。
     *
     * @param args
     */
    public static void main(String[] args) {
        readFileContent("D:\\download\\解压密码.png");
    }
}
