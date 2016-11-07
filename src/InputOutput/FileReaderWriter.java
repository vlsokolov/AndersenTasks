package InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		ReadWrite(args);
	}

	public static void ReadWrite(String[] args){
		try(FileOutputStream out = new FileOutputStream(args[2]);
		        FileInputStream in1 = new FileInputStream(args[0]);
		        FileInputStream in2 = new FileInputStream(args[1])){
			
			while(in1.available() > 0){
				byte[] buffer = new byte[in1.available()];
				int count = in1.read(buffer);
				out.write(buffer, 0, count);
			}
			
			while(in2.available() > 0){
				byte[] buffer = new byte[in2.available()];
				int count = in2.read(buffer);
				out.write(buffer, 0, count);
			}
			
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
