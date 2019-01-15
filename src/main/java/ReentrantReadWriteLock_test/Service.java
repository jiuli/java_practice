package ReentrantReadWriteLock_test;

import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
 * 在某些不需要操作实例变量的方法中，完全可以使用读写锁
 * ReentrantReadWriteLock来提升该方法的代码运行速度。
 * 即多个Thread可以同时进行读取操作，但是同一时刻只允许一个
 * Thread进行写入操作。*/
public class Service {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		try {
			try {
			lock.readLock().lock();
			System.out.println("获取读锁" + Thread.currentThread().getName()+ ""+
						System.currentTimeMillis());
			Thread.sleep(10000);
			}finally {
				lock.readLock().unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
