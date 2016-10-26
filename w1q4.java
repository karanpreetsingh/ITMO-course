import java.util.*;
import java.io.*;
import java.math.*;


public class Maintest  {
	
	

	public static void main(String[] args) throws IOException{
		
		
		int[] a = {1,2,3};
		int[] b = {6,5,4};
		int[] c = {7,8,9};
		double max = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(i != j && i != k && j != k){
						double temp = Math.pow(Math.pow((a[i]), 2) + Math.pow((b[j]), 2) + Math.pow((c[k]), 2), 0.5);
					

						if(temp > max)
							max = temp;
					}
				}
			}
		}		

		System.out.println(max);
	}	
}
