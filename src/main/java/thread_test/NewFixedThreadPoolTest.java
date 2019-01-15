package thread_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，
 * 直到线程达到线程池的最大大小。线程池的大小一旦达到最大值
 * 就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。*/
public class NewFixedThreadPoolTest {
/*
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * 定长线程池的大小最好根据系统资源进行设置。
 * 如Runtime.getRuntime().availableProcessors()。*/
	
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fixedThreadPool.execute(new Runnable(){
				public void run() {
					System.out.println(index);
					/*
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			});
		}
	}
}
