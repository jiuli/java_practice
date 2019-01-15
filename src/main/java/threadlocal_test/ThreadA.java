package threadlocal_test;

public class ThreadA extends Thread{
	
	public void run() {
		try{
			for (int i=0; i < 100; i++){
				Tools.t1.set("ThreadA" + (i+1));
				System.out.println("ThreadA get Value="+Tools.t1.get());
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
