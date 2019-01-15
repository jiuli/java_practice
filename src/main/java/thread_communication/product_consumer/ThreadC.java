package thread_communication.product_consumer;

public class ThreadC extends Thread{
	private C r;
	public ThreadC(C r) {
		super();
		this.r = r;
	}
	
	public void run() {
		while(true) {
			r.getValue();
		}
	}

}
