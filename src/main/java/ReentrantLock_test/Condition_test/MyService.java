package ReentrantLock_test.Condition_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();
	
	public Condition c = lock.newCondition();
	
	public void await(){
		try {
			lock.lock();
			System.out.println("await时间为"+System.currentTimeMillis());
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void signal() {
		try {
			lock.lock();
			System.out.println("signal时间为："+System.currentTimeMillis());;
			c.signal();
		}finally{
			lock.unlock();
		}
	}
}
