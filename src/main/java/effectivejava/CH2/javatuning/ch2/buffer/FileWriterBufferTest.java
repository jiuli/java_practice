package effectivejava.CH2.javatuning.ch2.buffer;

import org.junit.Test;

import java.io.*;

public class FileWriterBufferTest {
    public static final int CIRCLE = 100000;

    @Test
    public void testFileWriter() throws IOException {
        Writer writer = new FileWriter(new File("file.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriter spend:" + (System.currentTimeMillis() - begin));
    }

    @Test
    public void testFileWriterBuffer() throws IOException {
        //默认8k缓存区，应用了装饰者模式缓存组件BufferedOutputStream
        Writer writer = new BufferedWriter(new FileWriter(new File("file.txt")));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriterBuffer spend:" + (System.currentTimeMillis() - begin));

    }


}
