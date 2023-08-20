import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] coin = new int[n];
        long[] dp = new long[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);
        Arrays.fill(dp, 1000000000);
        dp[0] =0;

        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (coin[i] <= j ) {
                    if (j % coin[i] ==0) {
                        dp[j] = Math.min(dp[j], j/coin[i]);
                    }
                    else dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }


        if (dp[k]==1000000000) System.out.println(-1);
        else System.out.println(dp[k]);

    }

}
