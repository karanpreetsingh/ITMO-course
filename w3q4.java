import java.util.*;
import java.io.*;


public class ITMO{

  static void quickSort(int[] arr, int left, int right, int k1, int k2){
      int mid = arr[left + (right - left) / 2]; // WITHOUT MIDDLE EVEMENT AS PIVOT YOU GET TLE.
      int l = left;
      int r = right;
      while(l <= r){
        while(arr[l] < mid)
          l++;
        while(arr[r] > mid)
          r--;
        if(l <= r){
          int temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          l++;
          r--;
        }
      }
      if(left < r && ((k2 <= r) || (k1 <= r && k2 >= r))) // SORT ONLY THAT HALF JISKE RANGE CHAHIYE
        quickSort(arr, left, r, k1, k2);
      if(l < right && (k1 >= l || (k1 <= l && k2 >= l)))
        quickSort(arr, l, right, k1, k2);
    }

  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k1 = Integer.parseInt(token.nextToken());
        int k2 = Integer.parseInt(token.nextToken());
        k1--;
        k2--;
        int[] arr = new int[n];
        token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int a1 = Integer.parseInt(token.nextToken());
        int a2 = Integer.parseInt(token.nextToken());

        arr[0] = a1;
        arr[1] = a2;
        for(int i = 2; i < n; i++)
          arr[i] = a*arr[i - 2] + b*arr[i - 1] + c;

        //for(int x : arr)
        //System.out.print(x+" ");

        quickSort(arr, 0, n - 1, k1, k2);
        for(int i = k1; i <= k2; i++){
          out.print(arr[i]);
          out.print(" ");
        }
        //for(int x:arr)
          //System.out.print(x+" ");
        //System.out.println("");

  }
}
}
