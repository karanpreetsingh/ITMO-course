import java.util.*;
import java.io.*;


public class ITMO{
  static long count = 0;
  public static void mergeSort(int[] arr){
		if(arr.length > 1){
			int mid = arr.length / 2;
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for(int i = 0; i < mid; i++)
				left[i] = arr[i];
			for(int i = mid; i < arr.length; i++)
				right[i - mid] = arr[i];
			mergeSort(left);
			mergeSort(right);
			merge(left, right, arr);
		}
	}

	public static void merge(int[] left, int[] right, int[] arr){
		int l = left.length;
		int r = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < l && j < r){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
				k++;
			}
			else{
				arr[k] = right[j];
				k++;
				j++;
        count += l - i;  // Just only simple logic used. Made by me.
			}
		}
    /**
      * I AM FEELING THE NEED TO EXPLAIN THIS LOGIC SO THAT I CAN USE THIS IN FUTURE.
      * COUNT += L - I MEANS THAT THE RIGHT ARRAY ELEMENT IS SMALLER THAN THE L - I ELEMENTS IN THE
      * LEFT ARRAY WHICH IS THE VALUE OF INVERSION FOR THAT ELEMENT.
      */

		while(i < l){
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j < r){
			arr[k] = right[j];
			j++;
			k++;
		}
	}


  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        mergeSort(arr);
        out.println(count);
      }
  }
}
