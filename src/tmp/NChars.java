package tmp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * function to find all words of 'SIZE' length in a dictionary file
 */

public class NChars {

	public static final int SIZE = 4; 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("realhuman_phill.txt"));
		FileWriter fw1 = new FileWriter("realhuman-4chars.txt");
		try {
			String line = br.readLine();
			while (line != null) {
				if(line.length() == SIZE) {
					fw1.write(line+"\n");
					System.out.println(line);
				} 
				line = br.readLine();
			}
		} finally {
			br.close();
			fw1.close();
		}
	}




}
