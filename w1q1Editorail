This problem is very simple: just add two numbers and print the result.

Language: Java, outcome: Accepted, maximum time: 171 ms, maximum memory: 20168 kb.

This solution in Java uses java.util.Scanner. This is a convenient, but slow, way to read data file files.

This example also demonstrates the "Try-With-Resources" language construction, introduced in Java 7.

import java.io.*;
import java.util.*;

public class aplusb {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("aplusb.in"));
             PrintWriter out = new PrintWriter("aplusb.out")) {
            int a = in.nextInt(), b = in.nextInt();
            out.println(a + b);
        }
    }
}
Language: Java, outcome: Accepted, maximum time: 125 ms, maximum memory: 17844 kb.

This solution in Java uses java.io.BufferedReader to read files. This class (apart from what Reader can do) can read lines, and this is what we love it for. This class is fast enough for all practical purposes.

In fact, you can notice the impact of using Scanner even for such a simple problem: the running time is smaller for this solution (125 ms) than for the Scanner-based (171 ms), and this difference is statistically significant. This is because Scanner uses regular expressions to parse input, and even loading this machinery is already noticeable in the running time.

This example also demonstrates basic manipulations with String, including how to parse an int.

import java.io.*;
import java.util.*;

public class aplusb {
	public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("aplusb.in"));
             PrintWriter out = new PrintWriter("aplusb.out")) {
            String line = in.readLine();
            int whitespace = line.indexOf(' ');
            int a = Integer.parseInt(line.substring(0, whitespace));
            int b = Integer.parseInt(line.substring(whitespace + 1));
            out.println(a + b);
        }
    }
}
Language: Java, outcome: Accepted, maximum time: 125 ms, maximum memory: 17856 kb.

This solution in Java uses java.io.BufferedReader to read files, and java.util.StringTokenizer to split lines into parts. This is more convenient than the previous approach.

import java.io.*;
import java.util.*;

public class aplusb {
	public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("aplusb.in"));
             PrintWriter out = new PrintWriter("aplusb.out")) {
            StringTokenizer tok = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            out.println(a + b);
        }
    }
}
Language: Java, outcome: Accepted, maximum time: 125 ms, maximum memory: 17876 kb.

This solution in Java introduces an implementation of a neat abstraction you may use to read input for more complicated problems.

import java.io.*;
import java.util.*;

public class aplusb {
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

    public static void main(String[] args) throws IOException {
        try (FastScanner in  = new FastScanner("aplusb.in");
             PrintWriter out = new PrintWriter("aplusb.out")) {
            out.println(in.nextInt() + in.nextInt());
        }
    }
}
Language: Java, outcome: Accepted, maximum time: 312 ms, maximum memory: 25816 kb.

This solution in Java (ab)uses the new Java features: the NIO 2 input/output framework from Java 7, and the lambda functions available from Java 8.

You can also see that Java 8 features do not come for free. It does not, however, mean that the running time will be twice as large: it is mostly the time needed for the Java's LambdaMetaFactory machinery to start for the first time. However, use these features wisely!

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class aplusb {
    public static void main(String[] args) throws IOException {
        int sum = Files.lines(Paths.get("aplusb.in"))
                       .flatMap(s -> Arrays.stream(s.split(" ")))
                       .mapToInt(Integer::parseInt)
                       .sum();
        Files.write(Paths.get("aplusb.out"), Arrays.asList(String.valueOf(sum)));
    }
}
