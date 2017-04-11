import java.util.*;
import java.io.*;

public class ITMO{

  static boolean blackbox(int mid, int[] arr, int k){
    long left = k;
    left -= arr[0];

      for(int i = 1; i < arr.length; i++){
        int x = arr[i];
        x -= mid;
        if(x > 0)
          x -= (k - left);
        left -= mid;
        if(x > 0)
          left -= x;
      }
      if(left < 0)
        return false;
      else
        return true;
  }

  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          StringTokenizer token = new StringTokenizer(br.readLine());
          int n = Integer.parseInt(token.nextToken());
          int k = Integer.parseInt(token.nextToken());
          int[] arr = new int[n];
          long sum = 0;
          token = new StringTokenizer(br.readLine());
          for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
            sum += arr[i];
          }

          Arrays.sort(arr);

          if(sum <= (long)k)
            out.println(arr[0]);

          else{
            int min = 0;
            int max = arr[0];
            int plank = 0;
            while(min <= max){
              int mid = min + (max - min) / 2;
              //System.out.println(mid);
              if(blackbox(mid, arr, k)){
                plank = mid;
                min = mid + 1;
              }
              else
                max = mid - 1;
            }
            out.println(plank);
          }
    }
  }
}
