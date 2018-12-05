package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * function to split a large file (e.g. dictionary) into 4 equal sized chunks 
*/

public class Split {

	private static final String FILENAME = "rockyou.txt";
	private static final int CHUNKSIZE = 14344392/4; // 1/4 size of file
	public static final String OUTPUT_NAME = "rockyou"; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));

		FileWriter fw1 = new FileWriter(OUTPUT_NAME + "-chunk1.txt");
		FileWriter fw2 = new FileWriter(OUTPUT_NAME + "-chunk2.txt");
		FileWriter fw3 = new FileWriter(OUTPUT_NAME + "-chunk3.txt");
		FileWriter fw4 = new FileWriter(OUTPUT_NAME + "-chunk4.txt");

		try {
			String line = br.readLine();
			int lineCounter = 0; 
			while(line != null) {
				lineCounter++; 
				FileWriter fwPointer = null;
				if(lineCounter > 0 && lineCounter <= CHUNKSIZE) fwPointer = fw1; 
				else if(lineCounter > CHUNKSIZE && lineCounter <= CHUNKSIZE*2) fwPointer = fw2; 
				else if(lineCounter > CHUNKSIZE*2 && lineCounter <= CHUNKSIZE*3) fwPointer = fw3; 
				else if(lineCounter > CHUNKSIZE*3) fwPointer = fw4; 

				if(fwPointer != null) {
					fwPointer.write(line+"\n");
					System.out.println(line);
				}

				line = br.readLine();
			}
		} finally {
			fw1.close();
			fw2.close();
			fw3.close();
			fw4.close();
			br.close();
		}
	}

}
