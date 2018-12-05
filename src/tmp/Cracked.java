package tmp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/* 
 * function to remove all cracked hashes from the 
 * total list of hashes 
*/


public class Cracked {

	public static final int NUMBER_CRACKED = 205;
	public static String [] ar = new String[NUMBER_CRACKED]; 
	public static final String TO_CRACK_BACKUP = "to_crack/backups/SHA-512_to_crack.txt";
	public static final String CRACKED = "cracked/SHA-512_cracked.txt";
	public static final String TO_CRACK_NEW = "to_crack/SHA-512_to_crack.txt";
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(TO_CRACK_BACKUP));
		BufferedReader cr = new BufferedReader(new FileReader(CRACKED));
		FileWriter fw1 = new FileWriter(TO_CRACK_NEW);
		int i = 0;
		try {
			
			for(i = 0; i < NUMBER_CRACKED ; i++) {
				String lin = cr.readLine();
				ar[i] = lin.substring(0, lin.indexOf(':'));
			}
			
			String line = br.readLine();
			while (line != null) {
				if(!Arrays.asList(ar).contains(line)) { 
					fw1.write(line+"\n");
					System.out.println(line);
				} 
				line = br.readLine();
			}
		} catch (Exception e) {
			if(e instanceof NullPointerException) {
				System.out.println(i);
			}
		}
		finally {
			br.close();
			fw1.close();
			cr.close();
		}
	}
}
