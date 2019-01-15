package thread_communication.pipe_thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
	public static void main(String[] args) {
		try{
			WriteData writeData = new WriteData();
			ReadData readData = new ReadData();
			
			PipedOutputStream out = new PipedOutputStream();
			PipedInputStream input = new PipedInputStream();
			
			//input.connect(out);
			out.connect(input);
			ThreadRead r = new ThreadRead(readData, input);
			r.start();
			Thread.sleep(2000);
			
			ThreadWrite w = new ThreadWrite(writeData,out);
			w.start();
			
		}catch(IOException e){
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
