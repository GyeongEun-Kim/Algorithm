import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase= Integer.parseInt(br.readLine());
        for (int i=0;i<testcase;i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] max= new int[2][n];
            int answer =0;
            for (int j=0;j<2;j++) {
                String [] line = br.readLine().split(" ");
                for (int k=0;k<n;k++) {
                    sticker[j][k] = Integer.parseInt(line[k]);
                }
            }

            if (n==1) {
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
                continue;
            }

            max[0][0] = sticker[0][0];
            max[1][0] = sticker[1][0];
            max[0][1] = sticker[0][1] + sticker[1][0];
            max[1][1] = sticker[1][1] + sticker[0][0];

            if (n==2){
                System.out.println(Math.max(max[0][1], max[1][1]));
                continue;
            }

            for (int j=2;j<n;j++) {
                for (int k=0;k<2;k++) {
                    int swap;
                    if (k==0) swap=1;
                    else swap=0;
                    max[k][j]=sticker[k][j] + Math.max(Math.max(max[k][j-2], max[swap][j-1]), max[swap][j-2]);
                }
            }


            System.out.println(Math.max(max[0][n-1],max[1][n-1]));

        }
    }
}
