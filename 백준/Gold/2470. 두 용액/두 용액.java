import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int[] liquid =new int[n];
        for (int i=0;i<n;i++) liquid[i] = Integer.parseInt(input[i]);

        Arrays.sort(liquid);

        int res =Integer.MAX_VALUE;
        int start = 0;
        int end = n-1;
        int f =0;
        int s=0;

        while (start<end) {
            int sum= liquid[start] + liquid[end];

            if (sum >0) {
                if ( res > Math.abs(sum)) {
                    f= liquid[start];
                    s= liquid[end];
                    res = Math.min(res, Math.abs(sum));
                }
                end=end-1;
            }
            else if (sum<0) {
                if ( res > Math.abs(sum)) {
                    f= liquid[start];
                    s= liquid[end];
                    res = Math.min(res, Math.abs(sum));
                }
                start=start+1;

            }
            else { //합이 0이면
                f= liquid[start];
                s= liquid[end];
                break;
            }
        }
        System.out.println(f+" "+s);

    }
}


