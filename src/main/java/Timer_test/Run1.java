package Timer_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {
	private static Timer timer = new Timer();
	
	public static class MyTask extends TimerTask {
		public void run() {
			System.out.println("运行了！时间为："+new Date());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date_str = "2017-08-10 15:50:00";
			Date date_ref;
			date_ref = sdf.parse(date_str);
			System.out.println("字符串时间："+ date_ref.toLocaleString() + "当前时间："+ new Date().toLocaleString());
			timer.schedule(task, date_ref);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
