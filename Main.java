import java.util.*;
import java.io.*;
import java.math.*;


public class Main  {
	
	

	public static void main(String[] args) throws IOException{
		
		File file = new File("testgen.in");
		FileReader reader = new FileReader(file);
		Scanner sc = new Scanner(new BufferedReader(reader));
		String str = sc.nextLine();
		int n = Integer.parseInt(str);
		int factors = 0;
		int power = 1;
		int max = 0;
		int power_prev = 1;
		int x = 2;
		// All highly complex numbers are even numbers.
		for(int i = 2; i <= n; i += x){
			
			if(i >= 60)
				x = 10;
			factors = 0;
			power = 1;
			int temp = i;
			boolean flag = false;

			// All highly composite numbers greater than or equal to 60 are divisible by 10 (my observation).
			if((i < 60) || (i >= 60 && i % 12 == 0)){
			for (int j = 2; j <= temp / j; j++) {
				
                        while (temp % j == 0) { 
                        		flag = true;
                                temp /= j;
                                factors++;
                                
                        }

                        if(flag){
                     	   factors++;                        
                        	power *= factors;
                        	factors = 0;
                    }
                }
                if (temp > 1) {                	
                	
                	factors += 2;
                	power *= factors;     
                }
            if(power > power_prev){
            	max = i;
            	power_prev = power;
            }
        	}    	
		}
		int ans = n - max + 1;
		FileWriter writer = new FileWriter("testgen.out");
		writer.write(""+ans);
		writer.close();
		
			
		
		
	}	
}