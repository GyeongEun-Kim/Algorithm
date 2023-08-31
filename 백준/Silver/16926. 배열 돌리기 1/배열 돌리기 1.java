import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); //세로
        int m = Integer.parseInt(input[1]); //가로
        int rotate = Integer.parseInt(input[2]);

        int map[][] = new int[n][m];
        int result[][] =new int[n][m];

        for (int i=0;i<n;i++) {
            String line[] = br.readLine().split(" ");
            for (int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        } //input

        int outline = Math.min(n,m)/2; //돌릴 테두리 횟수



        for (int i=0;i<rotate;i++) { //돌리는 횟수
            for (int j=0;j<outline;j++) { //테두리 갯수
                int start = map[j][j];


                for(int k=j;k<m-j-1;k++) {//윗쪽변
                    map[j][k] = map[j][k+1];
                }
                for (int k=j;k<n-j-1;k++) {//오른쪽 변
                    map[k][m-j-1] = map[k+1][m-j-1];
                }
                for (int k=m-j-1;k>j;k--) { //아랫변
                    map[n-j-1][k]= map[n-j-1][k-1];
                }
                for (int k=n-j-1;k>j;k--) { //왼쪽변
                    map[k][j]= map[k-1][j];
                }

                map[j+1][j]= start;

            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }
}