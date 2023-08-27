import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=0;i<tc;i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);

            int len = n-1;
            int angle = Integer.parseInt(input[1]);
            if (angle<0) {
                angle = 360+angle;
            }//무조건 시계방향으로 돌리기 위해
            int turn = angle/45;

            int[][] map = new int[n][n];
            for (int j=0;j<n;j++) {
                String[] line = br.readLine().split(" ");
                for (int k=0;k<n;k++) {
                    map[j][k] = Integer.parseInt(line[k]);
                }
            } //input


            int middle = n/2; //정중앙 좌표
            int result[][] = map.clone();
            for (int c=0;c<turn;c++) { //45도씩 시계방향으로 돌리기
                List<Integer> sero = new ArrayList<>();
                List<Integer> garo = new ArrayList<>();
                for (int r=0;r<n;r++) {
                    garo.add(result[middle][r]);
                    sero.add(result[r][middle]);

                    result[middle][r] = result[len-r][r];
                    result[r][middle] = result[r][r];
                }
                for (int r=0;r<n;r++) {
                    result[r][len-r] = sero.get(r);
                    result[r][r] = garo.get(r);
                }

            }


            //print
            for (int a=0;a<n;a++){
                for (int b=0;b<n;b++) {
                    System.out.print(map[a][b]+" ");
                }
                System.out.println();
            }

        }
    }
}
