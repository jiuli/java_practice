package thread_communication.pipe_thread;

import java.io.PipedInputStream;

public class ThreadRead extends Thread{
	private ReadData read;
	private PipedInputStream input;
	
	public ThreadRead(ReadData read,PipedInputStream input) {
		super();
		this.read = read;
		this.input = input;
	}
	
	public void run() {
		read.readMethod(input);
	}
}
