package ReentrantLock_test.lock_methods;

import java.util.concurrent.locks.ReentrantLock;

public class Service1 {
	private ReentrantLock lock = new ReentrantLock();
	
	public void serviceMethod1() {
		try{
			lock.lock();
			System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
			serviceMethod2();
		}finally{
			lock.unlock();
		}
	}
	
	public void serviceMethod2() {
		try{
			lock.lock();
			System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
		}finally{
			lock.unlock();
		}
	}
}
