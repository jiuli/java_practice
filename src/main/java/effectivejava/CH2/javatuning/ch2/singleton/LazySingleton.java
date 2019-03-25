package effectivejava.CH2.javatuning.ch2.singleton;

public class LazySingleton {
    private LazySingleton() {
        //创建单例的过程可能会比较慢，使用延迟加载，这样系统编译就快
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    /**
     * 但是加上锁
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}