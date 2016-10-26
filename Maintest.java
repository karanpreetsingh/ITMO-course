import java.util.*;
import java.io.*;
import java.math.*;


public class Maintest  {
	
	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		/* Using mid point theorm and similarity of triangle distance between mid points of a and b = c / 2 */
		double ans = (x+y+z) / 6.0;
		System.out.println(ans);
	}	
}