package effectivejava.CH2.javatuning.ch2.singleton;

import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleton {

    @Test
    public void test() {
        //创建一个私有函数，确保单利不会在系统其他代码中被实例化
//		Singleton s = new Singleton();
        Singleton s = Singleton.getInstance();
        Singleton s1 = null;
        Class singletonClass = Singleton.class;
        Constructor cons;
        try {
            cons = singletonClass.getDeclaredConstructor((Class<?>) null);
            cons.setAccessible(true);
            s1 = (Singleton) cons.newInstance((Object) null);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Assert.assertNotSame(s, s1);
    }

    public static class AccessSingletonThread extends Thread {
        long begintime;

        public AccessSingletonThread(long begintime) {
            this.begintime = begintime;
        }

        @Override
        public void run() {
            System.out.println("try to get instance");
            for (int i = 0; i < 100000; i++)
                //Singleton.getInstance();
                LazySingleton.getInstance();
            System.out.println("spend:" + (System.currentTimeMillis() - begintime));
        }
    }

    @Test
    public void testPerformance() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(5);
        long begintime = System.currentTimeMillis();
        exe.submit(new AccessSingletonThread(begintime));
        exe.submit(new AccessSingletonThread(begintime));
        exe.submit(new AccessSingletonThread(begintime));
        exe.submit(new AccessSingletonThread(begintime));
        exe.submit(new AccessSingletonThread(begintime));

        Thread.sleep(10000);
    }

    @Test
    public void testSingleton() {
        StaticSingleton.createString();
        StaticSingleton.getInstance();
    }

}