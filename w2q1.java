import java.util.*;
import java.io.*;
import java.math.*;


public class Main  {
	
	

	public static void main(String[] args) throws IOException{
		
		File file = new File("stack.in");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		int n = Integer.parseInt(str);
		Stack stack = new Stack();
		FileWriter writer = new FileWriter("stack.out");
		StringBuilder sb = new StringBuilder("");
		while(n > 0){
			str = br.readLine();
			//What is faster : str.split(" ") or using this substring() method?
			if(str.length() > 1)
				stack.push(str.substring(2));
			else{
				sb.append(""+stack.pop()+"\n");
				
			}

			n--;
			
		}
		writer.write(""+sb);		
		br.close();
		writer.close();	
			
		
	}	
}
