package thread_communication.join_test;

public class MyThread extends Thread{
	public void run() {
		int v = (int) (Math.random() * 10000);
		System.out.println(v);
		try {
			Thread.sleep(v);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
