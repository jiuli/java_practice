package thread_communication.pipe_thread;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
	public void wirteMethod(PipedOutputStream outPutStream) {
		try {
			System.out.println("Write:");
			for(int i = 0; i < 300; i++){
				String outData = "" + (i+1);
				outPutStream.write(outData.getBytes());
				System.out.println(outData);
			}
			System.out.println("outPutStream closed");
			outPutStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
