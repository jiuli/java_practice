package ReentrantReadWriteLock_test;


public class Run {
	/* 读读共享：
	 * 通过后面时间相同判断，允许多个线程同时执行lock()方法
	 * 后面的代码。*/
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		ThreadB b = new ThreadB(service);
		b.setName("B");
		a.start();
		b.start();
	}
}
