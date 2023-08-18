import java.io.*;

public class Main {
    static long[] triangle;
    static long[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testcase = Integer.parseInt(br.readLine());
        triangle = new long[101];
        output = new long[testcase];


        triangle[1]=1;
        triangle[2]=1;
        triangle[3]=1;
        triangle[4]=2;
        triangle[5]=2;


        for (int i=0;i<testcase;i++) {
            Integer n = Integer.parseInt(br.readLine());
            output[i]=dp(n);
        }

        for (int i=0;i<output.length;i++) {
            System.out.println(output[i]);
        }
    }

    public static long dp (int i) {
        if (triangle[i]!= 0) return triangle[i];
        else {
            triangle[i] = dp(i-1) + dp(i-5);
            return triangle[i];
        }
    }
}
