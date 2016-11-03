import java.util.*;
import java.io.*;
import java.math.*;


public class Main  {
	
	

	public static void main(String[] args) throws IOException{		
		File file = new File("queue.in");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		int n = Integer.parseInt(str);
		int[] arr = new int[n];
		int head = 0, tail = 0;
		
		FileWriter writer = new FileWriter("queue.out");
		BufferedWriter bw = new BufferedWriter(writer);
		while(n > 0){
			str = br.readLine();
			
			if(str.length() > 1){
				arr[tail] = Integer.parseInt(str.substring(2));
				tail++;
			}
				
			else{
				bw.write(""+arr[head]+"\n");
				head++;				
			}

			n--;
			
		}
				
		br.close();
		bw.close();			
		
	}	
}