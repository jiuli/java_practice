package thread_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*创建一个单线程的线程池。这个线程池只有一个线程在工作，
 * 也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。*/
public class NewSingleThreadExecutorTest {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		
		for (int i=0; i < 10; i++){
			final int index = i;
			
			singleThreadExecutor.execute(new Runnable(){
				public void run() {
					System.out.println(index);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}); //结果依次输出，相当于顺序执行各个任务。
		}
	}
}
