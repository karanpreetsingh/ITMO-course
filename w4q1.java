import java.util.*;
import java.io.*;


public class Sol{

	static class FastScanner implements Closeable {
    BufferedReader in;
    StringTokenizer st;
    FastScanner(String filename) throws IOException {
        in = new BufferedReader(new FileReader(filename));
    }
    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
            	return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public void close() throws IOException {
        in.close();
        st = null;
    }
}

	static ArrayList<Integer> [] al;
	static int[] color;
	static Stack <Integer> stack = new Stack <Integer> ();

	static boolean dfs(int x){
		color[x] = 1;
		stack.push(x);

		for(int i = 0; i < al[x].size(); i++){

			if(color[al[x].get(i)] == 1){
				stack.push(al[x].get(i));
				return true;
			}

			else if(color[al[x].get(i)] == 0 && dfs(al[x].get(i))){
				return true;
			}				
		}

		color[x] = 2;
		stack.pop();
		return false;
	}


	public static void main(String[] args) throws IOException { 
		try(FastScanner sc = new FastScanner("input.txt");
			PrintWriter out = new PrintWriter("output.txt")){
		
			int m = sc.nextInt();
			int n = sc.nextInt();
			al = new ArrayList[m];
			color = new int[m];			
			
			for(int i = 0; i < m; i++)
				al[i] = new ArrayList <Integer> ();

			for(int i = 0; i < n; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				u--;v--;
				al[u].add(v);
			}

			for(int i = 0; i < m; i++)
				if(color[i] == 0 && dfs(i)){
					out.println("YES");
					ArrayList <Integer> a = new ArrayList <Integer> ();
					int x = stack.pop();
					a.add(x);
					while(stack.peek() != x)
						a.add(stack.pop());

					for(int j = a.size() - 1; j >= 0; j--)
						out.print((a.get(j) + 1)+" ");
					return;
				}
			
			out.println("NO");					
		}
	 }

}
