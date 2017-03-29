import java.util.*;
import java.io.*;


public class ITMO{
  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          int n = Integer.parseInt(br.readLine());
          StringTokenizer token = new StringTokenizer(br.readLine());
          PriorityQueue <Integer> pq = new PriorityQueue < > ();
          for(int i = 0; i < n; i++){
            int x= Integer.parseInt(token.nextToken());
            if(pq.size() == 0 && x == 0)
              pq.add(1);
            else if(x == 0){
              pq.add(pq.poll() + 1);
            }
            else{
              pq.add(1);
            }
          }
          int max = Integer.MIN_VALUE;
          for(int x : pq){
            max = Math.max(max, x);
          }
          out.println(max);
        }
  }
}
