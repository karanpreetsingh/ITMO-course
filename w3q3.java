import java.util.*;
import java.io.*;

public class ITMO{

  public static void main(String[] args) throws IOException{
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");){
          int n = Integer.parseInt(br.readLine());
          if(n == 1)
            out.println("1");
          else if(n == 2)
            out.println("1 2");
          else{
            /**
              * I OBSERVED FEW SEQUENCES AND FOUND THAT FOR WORST CASE THE MIDDLE ELEMENT MUST
              * BE IN THE CENTER. FOR N = 2 THE SEQUENCE IS 1 2 BUT FOR REST THE MAX ELEMENT IS IN THE MIDDLE     * AND THE PREVIOUS MIDDLE ELEMENT TO THE LAST USING BOTTOM UP APPROACH.
              * SO IF WE NEED FOR N = 5 I WILL GO FROM N = 1 TO N = 5.
              * IT GOES LIKE 1, 1 2, 1 3 2, 1 4 2 3, 1 4 5 3 2.
              */
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            for(int i = 2; i < n; i++){
            int temp = arr[(i / 2)];
            arr[i / 2] = i + 1;
            arr[i] = temp;
            }
            for(int x : arr){
              out.print(x);
              out.print(" ");
            }
          }

    }
  }
}
