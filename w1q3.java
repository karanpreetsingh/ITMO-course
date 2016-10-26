import java.util.*;
import java.io.*;


public class Maintest  {
	
	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pi = new int[n];
		int[] ti = new int[n];
		for(int i = 0; i < n; i++){
			pi[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			ti[i] = sc.nextInt();
		}
		int count = 0;
		int maxp = 1000, maxt = 1000, indexp = 0, indext = 0;
		boolean flagp = true, flagt = true;
		for(int i = 0; i < n; i++){
			if(pi[i] > ti[i]){
				System.out.println("p = "+pi[i]);
				count += pi[i];
				flagt = false;

				/* Taking the values with min difference */
				if(maxt > pi[i] - ti[i]){
					maxt = pi[i] - ti[i];
						indext = i;
				}
			}
			else{
				count += ti[i];
				System.out.println("t = "+ti[i]);
				flagp = false;
				if(maxp > ti[i] - pi[i]){
					maxt = ti[i] - pi[i];
						indexp = i;
				}
			}
		}

		if(flagt){
			System.out.println("p added = "+pi[indexp]);
			count -= ti[indexp];
			count += pi[indexp];

		}

		if(flagp){
			System.out.println("t added = "+ti[indext]);
			count -= pi[indext];
			count += ti[indext];

		}
		System.out.println(count);

		
	}	
}