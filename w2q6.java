import java.util.*;
import java.io.*;

class Snowman{
  int top;
  int parent;
  int mass;

  Snowman(){

  }

  Snowman(int top, int parent, int mass){
    this.top = top;
    this.parent = parent;
    this.mass = mass;
  }
}

public class ITMO{
  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          int n = Integer.parseInt(br.readLine());
          Snowman[] arr = new Snowman[n + 1];
          StringTokenizer token = new StringTokenizer("");
          long sum = 0;
          arr[0] = new Snowman(-1, 0, 0);
          for(int i = 1; i <= n; i++){
            token = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            if(m == 0){
              Snowman man = arr[p];
              man = arr[man.parent];
              sum += man.mass;
              arr[i] = new Snowman(man.top, man.parent, man.mass);
            }
            else{
              int total = m + arr[p].mass;
              arr[i] = new Snowman(m, p, total);
              sum += total;
            }
          }

          out.println(sum);
        }
  }
}
