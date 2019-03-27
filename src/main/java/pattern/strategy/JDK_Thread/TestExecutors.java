package pattern.strategy.JDK_Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;

/**
 * @author lijunsong
 * @date 2019/3/27 14:36
 * @since 1.0
 */
public class TestExecutors {
    /**
     * 在创建线程池的时候，经常使用一个工厂类来创建线程池Executors,
     * 实际上Executors的内部使用的是类ThreadPoolExecutor
     * public ThreadPoolExecutor(int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler)
     * RejectedExecutionHandler 是一个策略接口，
     * 用在当线程池中没有多余的线程来执行任务，并且保存任务的多列也满了（指的是有界队列），
     * 对仍在提交给线程池的任务的处理策略
     */
    Executors executors;
    RejectedExecutionHandler rejectedExecutionHandler;
    /**
     * 该策略接口有四个实现类：
     * 　    AbortPolicy:该策略是直接将提交的任务抛弃掉，并抛出RejectedExecutionException异常。
     *      DiscardPolicy:该策略也是将任务抛弃掉（对于提交的任务不管不问，什么也不做），不过并不抛出异常。
     *      DiscardOldestPolicy:该策略是当执行器未关闭时，从任务队列workQueue中取出第一个任务，并抛弃这第一个任务，
     *                  进而有空间存储刚刚提交的任务。使用该策略要特别小心，因为它会直接抛弃之前的任务。
     *      CallerRunsPolicy:该策略并没有抛弃任何的任务，由于线程池中已经没有了多余的线程来分配该任务，
     *                          该策略是在当前线程（调用者线程）中直接执行该任务。
     */
}
