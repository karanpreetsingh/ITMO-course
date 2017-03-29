import java.util.*;
import java.io.*;

public class Kenobi{
  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          int n = Integer.parseInt(br.readLine());
          String str = "";
          Deque <String> left = new ArrayDeque < > ();
          Deque <String> right = new ArrayDeque < > ();
          Deque <String> temp;
          for(int i = 0; i < n; i++){
            if(right.size() - left.size() > 1){
              left.addLast(right.removeFirst());
            }

            if(left.size() > right.size()){
              right.addFirst(left.removeLast());
            }
            str = br.readLine();
            String substr = str.substring(0,4);
            if(substr.equals("add ")){
              right.addLast(str.substring(4));
            }
            else if(substr.equals("take")){
              right.removeLast();
            }
            else{
              temp = left;
              left = right;
              right = temp;
            }
          }
          left.addAll(right);
          out.println(left.size());
          for(String x : left)
            out.print(x+" ");
        }
  }
}
