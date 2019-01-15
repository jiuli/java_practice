package thread_communication.wait_notify_insert;


/*
 * 等待/通知实现交叉备份*/
public class Run {
	public static void main(String[] args) {
		DBTools db = new DBTools();
		for (int i = 0; i < 20; i++){
			BackUpB output = new BackUpB(db);
			output.start();
			
			BackUpA input = new BackUpA(db);
			input.start();
		}
	}
}
