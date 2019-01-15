package thread_communication.wait_notify_insert;

public class BackUpA extends Thread{
	private DBTools db;
	
	public BackUpA(DBTools db) {
		super();
		this.db = db;
	}
	
	public void run() {
		db.backUpA();
	}
}
