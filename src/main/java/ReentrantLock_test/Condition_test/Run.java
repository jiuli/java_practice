package ReentrantLock_test.Condition_test;

public class Run {
	public static void main(String[] args) throws InterruptedException{
		MyService service = new MyService();
		ThreadA a = new ThreadA(service);
		a.start();
		Thread.sleep(3000);
		service.signal();
	}
}
