import java.util.*;
import java.io.*;

public class Sol{

	static ArrayList <Integer> [] al;
	static Queue <Integer> queue;
	static int[] color;

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


	static boolean bfs(){

		int c = -1;

		while(queue.size() != 0){

			int x = queue.remove();			
			
			if(color[x] == 0)
				color[x] = 1;
			
			if(color[x] == 1)
				c = 2;
			else
				c = 1;
			
			for(int i = 0; i < al[x].size(); i++){
				if(color[al[x].get(i)] == color[x])
					return true;

				else if(color[al[x].get(i)] == 0){
					color[al[x].get(i)] = c;
					queue.add(al[x].get(i));
				}				
			}

		}
		
		return false;

	}

	public static void main(String[] args) throws IOException{
		try(FastScanner sc = new FastScanner("input.txt");
			PrintWriter out = new PrintWriter("output.txt")){

			int n = sc.nextInt();
			int m = sc.nextInt();
			al = new ArrayList[n];
			queue = new LinkedList <Integer> ();
			color = new int[n];

			for(int i = 0; i < n; i++)
				al[i] = new ArrayList <Integer> ();

			for(int i = 0; i < m; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				u--;v--;
				al[u].add(v);
				al[v].add(u);
			}

				for(int i = 0; i < n; i++){
					queue.add(i);
					if(bfs()){
						out.println("NO");
						return;
					}						
				}

				out.println("YES");
			
		}
	}
}
