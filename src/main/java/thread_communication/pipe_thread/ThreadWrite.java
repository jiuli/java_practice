package thread_communication.pipe_thread;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread{
	private WriteData write;
	private PipedOutputStream out;
	
	public ThreadWrite(WriteData write, PipedOutputStream out) {
		super();
		this.write = write;
		this.out = out;
		}
	
	public void run() {
		write.wirteMethod(out);
	}

}
