import java.util.*;
import java.io.*;


public class ITMO{
  static boolean blackBox(int[] arr, int time, int k){
    int x = 0;
    int radiator = time;
    for(int i = 0; i < arr.length; i++){
      x = arr[i];
      x -= time;
      if(x > 0){
        //System.out.println(time+"  "+x+"  "+(k - 1)+"  "+(int)Math.ceil((double)x / (k - 1)));
        radiator -= (int)Math.ceil((double)x / (k - 1));
      }
      //System.out.println(time+"  "+radiator);
      if(radiator < 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          int n = Integer.parseInt(br.readLine());
          int[] arr = new int[n];
          int max = Integer.MIN_VALUE;
          StringTokenizer token = new StringTokenizer(br.readLine());
          for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
            max = Math.max(max, arr[i]);
          }
          int k = Integer.parseInt(br.readLine());

          int min = 1;
          int mid = 0;
          int ans = 0;
          while(min <= max){
            mid = min + (max - min) / 2;
            //System.out.println(mid);
            if(blackBox(arr, mid, k)){
              max = mid - 1;
              ans = mid;
            }
            else
              min = mid + 1;
          }

          out.println(ans);
    }
  }
}
