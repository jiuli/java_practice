package JVM_Test;

/**
 * 如何判断heap中对象已死？
 * 引用计算算法：对象被引用，引用计数器给对象加一，当引用失效时，计数器减一，当对象计数器为零时对象就是不可能再被引用
 * 但是Java没有用这个，因为很难解决对象之间相互循环引用的问题
 *
 * @author lijunsong
 * @date 2019/1/21 11:38
 * @since 1.0
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 唯一意义时站点内存，便于在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这里发生GC,那么objA和objB是否能被回收？
        System.gc();
    }
}
