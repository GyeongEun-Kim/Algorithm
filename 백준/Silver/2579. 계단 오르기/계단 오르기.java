import java.io.*;

public class Main{
    static Integer[] memo;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairs= Integer.parseInt(br.readLine());
        scores = new int[stairs+1];
        memo = new Integer[stairs+1];

        for (int i=1;i<=stairs;i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        memo[0] = 0;
        memo[1] = scores[1];

        if (stairs == 1) System.out.println(scores[1]);
        else if (stairs==2) System.out.println(scores[1]+scores[2]);
        else {
            memo[2] = scores[1] + scores[2];
            dp(stairs);
            System.out.println(memo[stairs]);
        }
        //memo[i] = Math.max(memo[i-2], memo[i-3]+scores[i-1]) +scores[i];

    }
    public static int dp(int i) {

        if (memo[i] != null) return memo[i];

        memo[i] =Math.max( dp(i-2), dp(i-3)+scores[i-1])+scores[i];

        return memo[i];
    }

    }
