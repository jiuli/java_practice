package thread_communication.pipe_thread;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
	public void readMethod(PipedInputStream inputStream) {
		try{
			System.out.println("read:");
			byte[] byteArray = new byte[20]; //字节流
			char[] charArray = new char[20]; //字符流
			int readLength = inputStream.read(byteArray); //从管道中读取数据。
			while(readLength != -1) {
				String newDate = new String(byteArray,0,readLength);
				System.out.println(newDate);
				readLength = inputStream.read(byteArray);
			}
			System.out.println("inputStream close");
			inputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
