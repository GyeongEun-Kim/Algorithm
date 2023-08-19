import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int answer = 0;
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int coin[] = new int[n];
        int method[] = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            coin[i] =value;
        }


        method[0]=1;
        /**
         * j==coin[i] 인 경우에 method[0]에 접근
         * ex) method[7]을 구해야하고 coin[i]= 7 일때 ,
         * method[7]= 7원짜리를 사용하지 않은 경우의수 + 7원짜리를 사용한 경우의 수
         * 이떄 7원을 만들기위해 7원짜리를 사용한 경우의 수는 무조건 1이기 때문에 method[0]=1로 초기화.
         */

        for (int i=0;i<coin.length;i++) {
            for (int j=1;j<=k;j++) {
                if(j>= coin[i])
                    method[j]= method[j] + method[j-coin[i]];
                /**
                 * j=7 , coin[i] = 2 일때
                 * method[7]= method[7] + method[5]
                 * ==> 2원짜리 코인을 사용하지 않은 기존 경우의수 + 사용한 경우의수(7원에서 2원을 미리 빼서 5원을 만드는 경우의수만 구하면됨)
                 */
            }
        }

        System.out.println(method[k]);
    }

}
