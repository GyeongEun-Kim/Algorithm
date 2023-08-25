import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};
    static int n;
    static int[][] resultMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] like = new int[(n*n)+1][5]; //선호하는 학생을 저장하는 배열
        resultMap = new int[n+1][n+1]; //자리 지정 완료된 배열

        for (int i=1;i<=n*n;i++) {
            String line[]= br.readLine().split(" ");
            for (int j=1;j<=4;j++) {
                int student =Integer.parseInt(line[0]);
                like[student][j] = Integer.parseInt(line[j]);

                if (j==4) selectSeat(student, like);
            }

        } //input


//        for (int i=1;i<=n;i++) {
//            for (int j =1;j<=n;j++) {
//                System.out.print(resultMap[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(preference(like));
    }


    public static void selectSeat (int student, int like[][]) {
        int maxLike=0;
        int maxBlank=0;

        int r=Integer.MAX_VALUE;
        int c=Integer.MAX_VALUE;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                int likeCnt = 0; //인접칸에 존재하는 선호 친구
                int blankCnt = 0;//인접칸에 존재하는 빈칸
                if (resultMap[i][j]!=0) continue;
                for (int k = 0; k < 4; k++) { //인접 칸 체크
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr >= 1 && nc >= 1 && nr <= n && nc <= n) {

                        if (resultMap[nr][nc] == 0)  //인접한 칸이 빈칸인 경우
                            blankCnt++;
                        else {
                            for (int l = 1; l <= 4; l++) {
                                if (resultMap[nr][nc] == like[student][l]) { //인접한 칸에 좋아하는 친구가 있는경우
                                    likeCnt++;
                                }
                            }
                        }
                    }
                }

                if (maxLike == likeCnt) { //조건1
                    if (maxBlank == blankCnt) { //조건2
                        if (r == i) { //조건3
                            if (c > j) c = j;
                        }
                        else if (r > i) {
                            r = i;
                            c = j;
                        }
                    }
                    else if (maxBlank < blankCnt) {
                        maxBlank = blankCnt;
                        r= i;
                        c=j;
                    }
                }
                else if (maxLike < likeCnt) {
                    maxLike = likeCnt;
                    maxBlank= blankCnt;
                    r= i;
                    c=j;
                }

            }
        }
        resultMap[r][c] = student;
    }


    public static int preference (int[][] like) { //선호도 조사
        int result=0;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                int student = resultMap[i][j];
                int preferCnt =0;
                for (int k=0;k<4;k++) {
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if (nr>=1 && nc>=1 && nr<=n && nc<=n) {
                        for (int l = 1; l <= 4; l++) {
                            if (resultMap[nr][nc] == like[student][l]) {
                                preferCnt++;
                            }
                        }
                    }
                }
                if (preferCnt==1) result+=1;
                else if (preferCnt==2) result+=10;
                else if (preferCnt==3) result+=100;
                else if (preferCnt==4) result+=1000;
            }
        }
        return result;
    }


}
