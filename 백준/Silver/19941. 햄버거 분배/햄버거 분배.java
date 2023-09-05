import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); //식탁 길이
        int k = Integer.parseInt(s[1]);//햄최몇
        String info = br.readLine();
        int cnt =0;
        boolean visit[] = new boolean[n];

        //사람을 기준으로 가장 왼쪽에 있는 햄버거를 먹어야함
        for (int i=0;i<n;i++) {
            if(info.charAt(i)=='P') {
                for (int j=i-k;j<=i+k;j++) {
                    if (j>=0 && j<n) {
                        if (info.charAt(j) == 'H' && visit[j] == false) {
                            cnt++;
                            visit[j] = true;
                            break;
                        }
                    }
                }
            }
        }


        System.out.println(cnt);

    }
}
