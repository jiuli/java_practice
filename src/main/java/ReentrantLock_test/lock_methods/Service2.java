package ReentrantLock_test.lock_methods;

import java.util.concurrent.locks.ReentrantLock;

public class Service2 {
	public ReentrantLock lock = new ReentrantLock();
	
	public void serviceMethod1() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName()+"进入方法！");
		
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}
