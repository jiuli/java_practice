package InheritableThreadLocal_test;

public class Run {
	public static void main(String[] args) {
		try {
			for( int i = 0; i < 100; i++) {
				System.out.println("Main线程中取值"+Tools.t1.get());
					Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadA a = new ThreadA();
			a.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
