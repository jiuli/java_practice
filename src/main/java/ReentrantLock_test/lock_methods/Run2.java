package ReentrantLock_test.lock_methods;

public class Run2 {
	public static void main(String[] args) throws InterruptedException {
		final Service2 s = new Service2();
		
		Runnable r = new Runnable(){
			public void run() {
				s.serviceMethod1();
			}
		};
		
		Thread[] t_array = new Thread[10];
		for(int i = 0; i < 10; i++) {
			t_array[i] = new Thread(r);
		}
		
		for(int i = 0; i < 10; i++){
			t_array[i].start();
		}
		
		Thread.sleep(2000);
		System.out.println("有线程数："+s.lock.getQueueLength() + "在等待获取锁！");
	}
}
