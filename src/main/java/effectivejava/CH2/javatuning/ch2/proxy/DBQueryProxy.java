package effectivejava.CH2.javatuning.ch2.proxy;

public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        //在真正需要的时候 ，才创建真实对象，创建过程可能很慢
        if (real == null) {
            real = new DBQuery();
        }
        //在多线程环境下，这里返回一个虚假类，类似于Future模式
        /**
         * Future的核心思想是：一个方法f，计算过程可能非常耗时，等待f返回，显然不明智。可以在调用f的时候，
         * 立马返回一个Future，可以通过Future这个数据结构去控制方法f的计算过程
         */
        return real.request();
    }
}
