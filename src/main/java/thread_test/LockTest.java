package thread_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockTest
 * 1）synchronized是独占锁，加锁和解锁的过程自动进行，易于操作，但不够灵活。ReentrantLock也是独占锁，加锁和解锁的过程需要手动进行，不易操作，但非常灵活。
 * <p>
 * （2）synchronized可重入，因为加锁和解锁自动进行，不必担心最后是否释放锁；ReentrantLock也可重入，但加锁和解锁需要手动进行，且次数需一样，否则其他线程无法获得锁。
 * <p>
 * （3）synchronized不可响应中断，一个线程获取不到锁就一直等着；ReentrantLock可以相应中断。
 * <p>
 * ReentrantLock好像比synchronized关键字没好太多，我们再去看看synchronized所没有的，
 * 一个最主要的就是ReentrantLock还可以实现公平锁机制。什么叫公平锁呢？也就是在锁上等待时间最长的线程将获得锁的使用权。
 * 通俗的理解就是谁排队时间最长谁先执行获取锁。
 *
 * @author lijunsong
 * @date 2021/6/1 10:00
 * @since 1.0
 */
public class LockTest {
    private static final Lock lock = new ReentrantLock();
    /**
     * 参数为true，表明实现公平锁机制
     */
    private static final Lock lock1 = new ReentrantLock(true);

    private static final Lock lock2 = new ReentrantLock();
    private static final Lock lock3 = new ReentrantLock();

    /**
     * 加锁lock和解锁unlock的过程需要手动进行
     */
    public static void test() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
    }

    /**
     * 公平锁
     */
    public static void test1() {
        for (int i = 0; i < 3; i++) {
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    /**
     * 非公平锁
     */
    public static void test2() {
        for (int i = 0; i < 3; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 限时等待
     * <p>
     * 就是通过我们的tryLock方法来实现，可以选择传入时间参数，表示等待指定的时间，
     * 无参则表示立即返回锁申请的结果：true表示获取锁成功，false表示获取锁失败。我们可以将这种方法用来解决死锁问题
     */

    static class ThreadDemo1 implements Runnable {
        Lock lock_1;
        Lock lock_2;

        public ThreadDemo1(Lock lock_1, Lock lock_2) {
            this.lock_1 = lock_1;
            this.lock_2 = lock_2;
        }

        @Override
        public void run() {
            try {
                if (!lock_1.tryLock()) {
                    TimeUnit.SECONDS.sleep(10);
                }
                if (!lock_2.tryLock()) {
                    TimeUnit.SECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock_1.unlock();
                lock_2.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束");
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(() -> test(), "线程A").start();
//        new Thread(() -> test(), "线程B").start();
//        /**
//         * 公平锁
//         */
//        new Thread(() -> test1(), "线程A").start();
//        new Thread(() -> test1(), "线程B").start();
//        new Thread(() -> test1(), "线程C").start();
//        new Thread(() -> test1(), "线程D").start();
//        new Thread(() -> test1(), "线程E").start();
//        /**
//         * 非公平锁
//         */
//        new Thread(() -> test(), "线程A").start();
//        new Thread(() -> test(), "线程B").start();
//        new Thread(() -> test(), "线程C").start();
//        new Thread(() -> test(), "线程D").start();
//        new Thread(() -> test(), "线程E").start();
//        /**
//         * 响应中断就是一个线程获取不到锁，不会傻傻的一直等下去，ReentrantLock会给予一个中断回应
//         */
//        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
//        Thread thread1 = new Thread(new ThreadDemo(lock1, lock2));
//        thread.start();
//        thread1.start();
//        //第一个线程中断
//        thread.interrupt();

        /**
         * 一个线程获取lock1时候第一次失败，那就等10毫秒之后第二次获取，
         * 就这样一直不停的调试，一直等到获取到相应的资源为止
         */
        Thread thread2 = new Thread(new ThreadDemo1(lock1, lock2));
        Thread thread3 = new Thread(new ThreadDemo1(lock1, lock2));
        thread2.start();
        thread3.start();
        //第一个线程中断
        thread2.interrupt();
    }

    static class ThreadDemo implements Runnable {
        Lock lock_1;
        Lock lock_2;

        public ThreadDemo(Lock lock_1, Lock lock_2) {
            this.lock_1 = lock_1;
            this.lock_2 = lock_2;
        }

        @Override
        public void run() {
            try {
                lock_1.lockInterruptibly();
                TimeUnit.SECONDS.sleep(5);
                lock_2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock_1.unlock();
                lock_2.unlock();
                System.out.println(Thread.currentThread().getName() + "获取资源，正常结束");
            }
        }
    }
}
