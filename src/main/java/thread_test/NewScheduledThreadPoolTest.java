package thread_test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {
/*创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 * 创建一个定长线程池，支持定时及周期性任务执行。
 * ScheduledExecutorService比Timer更安全，功能更强大，后面会有一篇单独进行对比*/
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		scheduledThreadPool.schedule(new Runnable(){
			public void run(){
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS); //延迟3秒执行
		
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
				public void run(){
					System.out.println("delay 1 seconds, and excute every 3 seconds.");
				}
		}, 1, 3, TimeUnit.SECONDS);
	}
}
