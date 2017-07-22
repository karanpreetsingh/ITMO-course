import java.util.*;
import java.io.*;

class Pair{
	int v;
	int w;

	public Pair(int w, int v){
		this.v = v;
		this.w = w;
	}
}

public class Solution{

	static int[] to, from, w, d;
	static ArrayList <Integer> [] al;
	static PriorityQueue <Pair> q;

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
			int m = sc.nextInt();
			
			to = new int[m];
			from = new int[m];
			w = new int[m];
			d = new int[n];
			al = new ArrayList[n];


			for(int i = 0; i < n; i++)
				al[i] = new ArrayList <Integer> ();

			for(int i = 0; i < m; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				u--;v--;
				from[i] = u;
				to[i] = v;
				int wi = sc.nextInt();
				w[i] = wi;
				al[u].add(i);
				al[v].add(i);
			}

			Arrays.fill(d, Integer.MAX_VALUE);
			d[0] = 0;

			q = new PriorityQueue < > (m, new Comparator <Pair> (){

				public int compare (Pair a, Pair b){
					if(a.w < b.w)
						return -1;
					else
						return 1;
				}
			});

			q.add(new Pair(0, 0));
			while(q.size() != 0){

				Pair p = q.poll();
				
				if(p.w == d[p.v]){
					for(int x : al[p.v]){
						int v = to[x] + from[x] - p.v;
						if(d[v] > d[p.v] + w[x]){
							d[v] = d[p.v] + w[x];
							q.add(new Pair(d[v], v));
						}
					}
				}
			}

			for(int x : d)
			out.print(x+" ");
		}
	}
}
