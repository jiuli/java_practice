package ReentrantLock_test.Condition_test;

public class ThreadA extends Thread{
	private MyService service;
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}
	public void run() {
		service.await();
		System.out.println("after await");
	}
}
