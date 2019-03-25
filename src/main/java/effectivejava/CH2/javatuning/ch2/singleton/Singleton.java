package effectivejava.CH2.javatuning.ch2.singleton;

public class Singleton {
    /**
     * 创建一个私有函数，确保单利不会在系统其他代码中被实例化
     */
    private Singleton() {
        //创建单例的过程可能会比较慢
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("createString in Singleton");
    }
}