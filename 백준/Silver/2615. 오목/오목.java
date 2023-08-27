import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int map[][] = new int[20][20];
        for (int i=1;i<=19;i++) {
            String line[] = br.readLine().split(" ");
            for (int j=1;j<=19;j++) {
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        } //오목판 input

        /**
         * 이중포문 탐색 + 8방향 탐색 (5방향 탐색안하는 이유: 6개 연결돼있어도 중간부터 탐색하면 5개라고 인식할수도)
         * 20 * 20 * 8
         */

        int[]  dx = {-1,0, 1, -1 , 1, -1, 0, 1};
        int[]  dy = {-1,-1, -1, 0,0 ,1, 1,1 };
        int win=0;
        int winX=0;
        int winY=0;

        outLoop:
        for (int i=1;i<20;i++) {
            for (int j=1;j<20;j++) {
                int color;
                int cnt;
                if(map[i][j]==0) continue;
                else {
                    color =map[i][j];
                }

                int[] dCnt = new int[8];
                for (int d=0;d<8;d++) {
                    int nx = j + dx[d];
                    int ny = i + dy[d];
                    cnt=1;

                    while (nx>=1 && ny>=1 && nx<=19 && ny<=19 && map[ny][nx]==color) {
                        cnt++;
                        nx += dx[d];
                        ny += dy[d];


                    }
                    dCnt[d]= cnt;
                }
                for (int c=0;c<4;c++) {
                    if (dCnt[c]+dCnt[7-c]-1==5){
                        win = color;
                        if (c==2) {
                            winX=j-4;
                            winY= i+4;
                        }
                        else {
                            winX = j; //9->5
                            winY = i; // 3->7
                        }
                        break outLoop;
                    }
                }
            }
        }

        System.out.println(win);
        if(win==1 || win==2) System.out.println(winY+" "+winX);


    }
}
