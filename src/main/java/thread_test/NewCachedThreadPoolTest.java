package thread_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {
	/*
	 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，

	*那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
	*此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小
	*做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。*/
	public static void main(String[] args) {
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		 for (int i = 0; i < 10; i++) {
			 final int index = i;
			 /* 对index进行了处理，jvm对线程没有进行优化，输出的index是按代码自然顺序输出的。
			  * 去掉index试试，证明上面的说法是错误的，只是用Thread.sleep()使得输出按代码自然输出！
			 try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} */
			// System.out.println(index+"1"); //对index处理，jvm还是对线程进行优化！
			 cachedThreadPool.execute(new Runnable(){
				 public void run() {
					 /*放上面和下面输出结果不一样!
					 try {
							Thread.sleep(index * 1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} */
					 System.out.println(index);
					 /*放上面和下面输出结果不一样!
					 try {
							Thread.sleep(index * 1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}*/
				 }
			 });
			 
		 }
		 
	}
}
