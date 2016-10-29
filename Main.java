import java.util.*;
import java.io.*;
import java.math.*;


public class Main  {
	
	

	public static void main(String[] args) throws IOException{
		File file = new File("template.in");
		FileReader reader = new FileReader(file);
		Scanner sc = new Scanner(new BufferedReader(reader));
		String str = sc.nextLine();
		String[] wh = str.split(" ");
		int w = Integer.parseInt(wh[0]);
		int h = Integer.parseInt(wh[1]);
		Map <Character, Integer> maph = new HashMap <Character, Integer> ();
		Map <Character, Integer> mapw = new HashMap <Character, Integer> ();

		
		for(int i = h; i > 0; i--){
			str = sc.nextLine();
			for(int j = 1; j <= w; j++){
				
				//System.out.println(str+" i j "+i+" "+j);
				char c = str.charAt(j-1);
				mapw.put(c, j);
				maph.put(c, i);
			}

		}

		int count = 0;
		int count_max = 0;
		String lang = "";
		int l = 3;
		int y = 0;
		int x = 0;
		boolean flag = false;
		// For the blank line after the keyboard is entered.
		sc.nextLine();

		// For comparing last char to first char of next line.
		int x_prev = 0;
		int y_prev = 0;
		int line = 0;
		while(l > 0){
			line = 0;
			count = 0;
			String lang_new = sc.nextLine();
			while(true){
				str = sc.nextLine();
				if(str.equals(""))
					break;
				int len = str.length();
				
				if(line != 0){

					y = Math.abs(maph.get(str.charAt(0)) - y_prev);
					x = Math.abs(mapw.get(str.charAt(0)) - x_prev);
					//System.out.println(x+" "+y);
					if(y > x)
						count += y;
					else
						count += x;
					//System.out.println(lang_new+" "+count+" extra");
				}

				for(int i = 0; i < len - 1; i++){
					y = Math.abs(maph.get(str.charAt(i)) - maph.get(str.charAt(i + 1)));
					x = Math.abs(mapw.get(str.charAt(i)) - mapw.get(str.charAt(i + 1)));

					if(y > x)
						count += y;
					else
						count += x;
					//System.out.println(lang_new+" "+count);
				}

					// Last char of line with first char of next line.
					x_prev = Math.abs(mapw.get(str.charAt(len - 1)));
					y_prev = Math.abs(maph.get(str.charAt(len - 1)));
					line++;
				
			}
				
				if(count < count_max || l == 3){
					lang = lang_new;
					count_max = count;
				}
				
				l--;
		}

		//System.out.println(""+lang+"\n"+""+count_max);	
		FileWriter writer = new FileWriter("template.out");
		writer.write(""+lang+"\n"+""+count_max);
		writer.close();
		
	}	
}