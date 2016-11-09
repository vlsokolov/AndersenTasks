package InputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		ReadWrite(args);
	}

	public static void ReadWrite(String[] args){

		try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			BufferedReader reader1 = new BufferedReader(new FileReader(args[1]));
			BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]))){
			
			String line;
			while((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			writer.newLine();
			
			while((line = reader1.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
