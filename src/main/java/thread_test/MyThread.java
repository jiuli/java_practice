package thread_test;

public class MyThread extends Thread{
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 执行中。。。。。。。。");
	}
	
}
