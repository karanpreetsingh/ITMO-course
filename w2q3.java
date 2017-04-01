import java.util.*;
import java.io.*;

public class Solution{
  public static void main(String[] args) throws IOException{
    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
         PrintWriter out = new PrintWriter("output.txt")) {
            int n = Integer.parseInt(br.readLine());
            Stack <Integer> queue = new Stack < > ();
            Stack <Integer> min = new Stack < > ();
            int mini = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
              String str = br.readLine();
              char c = str.charAt(0);
              if(c == '+'){
                int x = Integer.parseInt(str.substring(2));
                queue.push(x);
                mini = Math.min(mini, x);
              }
              else{
                if(min.empty()){
                  while(!queue.empty()){
                    if(min.empty())
                      min.push(queue.pop());
                    else{
                      min.push(Math.min(queue.pop(), min.peek()));
                    }
                  }
                  mini = Integer.MAX_VALUE;
                }

                if(c == '-')
                  min.pop();
                else
                  out.println(Math.min(min.peek(), mini));
              }
            }
         }
  }
}
