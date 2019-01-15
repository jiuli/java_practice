package thread_communication.product_consumer;

/*
 * 等待/通知模式最经典的案例就是‘生产者和消费者’模式，但此模式
 * 在使用上有几种‘变形’，还有一些小的注意事项。*/
public class P {
	private String lock;
	
	public P(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		try{
			synchronized(lock) {
				if (!ValueObject.value.equals("")){
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.value = value;
				lock.notify();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
