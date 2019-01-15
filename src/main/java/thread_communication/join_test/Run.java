package thread_communication.join_test;

public class Run {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("我想当t对象执行完毕后我再执行。");
		System.out.println("但是上面代码中sleep()中的值应该写多少呢");
		System.out.println("答案是：根据不能确定：");
	}
}
