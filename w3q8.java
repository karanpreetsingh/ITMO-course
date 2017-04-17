import java.io.*;
import java.util.*;

public class ITMO{

  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          StringTokenizer token = new StringTokenizer(br.readLine());
          int n = Integer.parseInt(token.nextToken());
          int k = Integer.parseInt(token.nextToken());
          int[] arr = new int[n];

          token = new StringTokenizer(br.readLine());
          for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(token.nextToken());

          ArrayList<Integer>[] al = new ArrayList[k];
          for(int i = 0; i < k; i++)
            al[i] = new ArrayList < > ();

          for(int i = 0; i < n; i++)
            al[i % k].add(arr[i]);

          for(int i = 0; i < k; i++)
            Collections.sort(al[i]);
          Arrays.sort(arr);

          int j = -1;
          for(int i = 0; i < n; i++){
            if(i % k == 0)
              j++;
            if(arr[i] != al[i % k].get(j)){
              out.println("NO");
              return;
            }
          }

          out.println("YES");
    }
  }
}
