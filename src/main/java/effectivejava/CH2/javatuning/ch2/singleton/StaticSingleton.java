package effectivejava.CH2.javatuning.ch2.singleton;

public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton is create");
    }

    /**
     * 通过写内部静态类实现，即可做到延迟加载，也不必使用同步关键字
     */
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void createString() {
        System.out.println("createString in Singleton");
    }
}