import java.util.*;
import java.io.*;


public class Postfix {
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("postfix.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("postfix.out"));
		String str = br.readLine();
		Stack <Integer> stack = new Stack <Integer> ();
		for(int i = 0; i < str.length(); i+= 2){
			//System.out.println(str[i]);
			int x, y;
			if(str.charAt(i) == '-'){
				//System.out.println("push -");
				y = stack.pop();
				x = stack.pop();
				stack.push(x - y);
			}
			else if(str.charAt(i) == '+'){
				//System.out.println(" push +");
				y = stack.pop();
				x = stack.pop();
				stack.push(x + y);
			}
			else if(str.charAt(i) == '*'){
				//System.out.println(" push *");
				y = stack.pop();
				x = stack.pop();
				stack.push(x * y);
			}
			else if(str.charAt(i) == '/'){
				System.out.println(" push /");
				y = stack.pop();
				x = stack.pop();
				stack.push(x / y);
			}
			else{
				//System.out.println("push");
				stack.push(Integer.parseInt(""+str.charAt(i)));
			}
		}

		bw.write(""+stack.pop());
		br.close();
		bw.close();

	}	
}