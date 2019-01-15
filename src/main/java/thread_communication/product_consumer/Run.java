package thread_communication.product_consumer;

public class Run {
	public static void main(String[] args) {
		String lock = new String("");
		//lock是全局变量，synchronized(lock)同步，
		//lock.wait(),lock.notify()实现对象间的通信！
		P p = new P(lock);
		C r = new C(lock);
		
		ThreadP pt = new ThreadP(p);
		ThreadC ct = new ThreadC(r);
		
		pt.start();
		ct.start();
	}
}
