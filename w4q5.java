import java.util.*;
import java.io.*;


public class Solution{

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


	public static void main(String[] args) throws IOException{
		try(FastScanner sc = new FastScanner("input.txt");
			PrintWriter out = new PrintWriter("output.txt")){
			
			int n = sc.nextInt();
			int s = sc.nextInt();
			int f = sc.nextInt();
			s--;f--;
			int[][] w = new int[n][n];
			long[] d = new long[n];
			boolean[] min = new boolean[n];

			Arrays.fill(d, Long.MAX_VALUE);
			d[s] = 0;

			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					w[i][j] = sc.nextInt();

			while(true){

				int v = -1;
				long m = Long.MAX_VALUE;
				for(int i = 0; i < n; i++)
					if(!min[i] && d[i] != Long.MAX_VALUE)
						if(d[i] < m){
							m = d[i];
							v = i;
						}

				if(v == f){
					min[v] = true;
					break;
				}

				if(v == -1)
					break;

				min[v] = true;

				for(int i = 0; i < n; i++){
					if(w[v][i] != -1){
						d[i] = (long)Math.min(d[i], d[v] + (long)w[v][i]);
					}
				}

				
			}

			if(min[f])
				out.println(d[f]);
			else
				out.println("-1");
		}
	}
}
