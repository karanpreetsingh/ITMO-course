import java.util.*;
import java.io.*;


public class Bracket {
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("brackets.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("brackets.out"));
		
		String str = "";
		while((str = br.readLine()) != null){
			Stack <Character> stack = new Stack <Character> ();
			System.out.println(str);
			int len = str.length();
			boolean flag = true;
		
			if(len % 2 != 0)
				flag = false;
		
			else{
				for(int i = 0; i < len; i++){
					char c = str.charAt(i);
					if(c == '[')
						stack.push(']');
					else if(c == '(')
						stack.push(')');
					else{

						if(stack.empty()){
							flag = false;
							break;
						}
						else if(c != stack.pop()){
							flag = false;
							break;
						}
					}
				}
			}
			if(flag && stack.empty()){
				bw.write("YES\n");
				System.out.println("YES");
			}
			else{
				bw.write("NO\n");
				System.out.println("NO");
			}

		}

		br.close();
		bw.close();
	}	
}