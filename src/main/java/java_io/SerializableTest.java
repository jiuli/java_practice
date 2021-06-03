package java_io;

import lombok.SneakyThrows;

import java.io.*;

/**
 * SerializableTest
 * 序列化就是将一个对象转换成字节序列，方便存储和传输
 *
 * @author lijunsong
 * @date 2021/5/25 14:41
 * @since 1.0
 */
public class SerializableTest {
    @SneakyThrows
    public static void main(String[] args) {
        Test test = new Test(10, "hello world");
        String objectFile = "D:\\download\\解压密码.png";

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objectFile));
        out.writeObject(test);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(objectFile));
        Test test1 = (Test) in.readObject();
        in.close();
        System.out.println(test1);
    }

    private static class Test implements Serializable {
        private int x;
        private String y;
        /**
         * transient 关键字可以使一些属性不会被序列化
         * 这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化，
         * 意思是transient修饰的字段，他的生命周期仅仅在内存中，不会被写到磁盘中
         */
        private transient Object[] elementData;

        Test(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + " " + "y = " + y;
        }

    }
}
