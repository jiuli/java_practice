package effectivejava.CH2.javatuning.ch2.decorator.output;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    /**
     * 装饰者模式应用类
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\a.txt")));
        //DataOutputStream dout=new DataOutputStream(new FileOutputStream("C:\\a.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dout.writeLong(i);
        }
        System.out.println("spend:" + (System.currentTimeMillis() - begin));
    }

}
