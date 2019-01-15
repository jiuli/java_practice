package thread_communication.wait_notify_insert;

public class BackUpB extends Thread{
	private DBTools db;
	
	public BackUpB(DBTools db){
		this.db = db;
	}
	
	public void run() {
		db.backUpB();
	}
}
