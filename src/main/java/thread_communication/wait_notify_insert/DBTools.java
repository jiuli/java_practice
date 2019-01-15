package thread_communication.wait_notify_insert;

public class DBTools {
	volatile private boolean isA = false;
	synchronized public void backUpA(){
		try {
			while(isA == true) {
				wait();
			}
			for( int i = 0 ; i < 5; i++){
				System.out.println("*****");
			}
			isA = true;
			notifyAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public void backUpB() {
		try{
			while(isA == false) { //isA为false时线程等待
				wait();
			}
			for(int i = 0; i< 5; i++){
				System.out.println("&&&&&&&&&&");
			}
			isA = false;
			notifyAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
