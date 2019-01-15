package thread_test;

public class TraditionalThread {
	/*
	 * 那你就out太多了，new Thread的弊端如下：
	a. 每次new Thread新建对象性能差。
	b. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom。
	c. 缺乏更多功能，如定时执行、定期执行、线程中断。
	相比new Thread，Java提供的四种线程池的好处在于：
	a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
	b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
	c. 提供定时执行、定期执行、单线程、并发数控制等功能。*/
	public static void main(String[] args) {
		System.out.println("Before.......");
		new Thread(new Runnable(){
			public void run() {
				System.out.println("jasonli......");
			}
		}).start();
	}
}
