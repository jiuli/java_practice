package ReentrantLock_test;

public class MyThread extends Thread{
	private MyService service;
	
	public MyThread(MyService service){
		super();
		this.service = service;
	}
	
	public void run() {
		service.testMethod();
	}

}
