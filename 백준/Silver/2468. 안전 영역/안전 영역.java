import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int region[][];
    static boolean visited[][];
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        int max=Integer.MIN_VALUE;
        region = new int[N][N];


        for (int i=0;i<N;i++) {
            String s[]=br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                region[i][j] = Integer.parseInt(s[j]);
                if (max<=region[i][j])
                    max=region[i][j];
            }
        }//영역 입력받기

        ArrayList<Integer> list = new ArrayList<>();
        for (int h=0;h<=max;h++) { //강수량 1씩증가
            int safe=0; //강수량의 안전영역 카운트
            visited =new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]==false && region[i][j]>h) {
                        dfs(h, j, i);
                        safe++;
                    }
                }
            }
            list.add(safe);
        }

        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list.get(0));

    }

    public static void dfs (int h, int i, int j) {
        visited[j][i]=true;
        Point current = new Point(i,j);

        for (int a=0;a<4;a++) {
            int nx = current.x + dx[a];
            int ny = current.y + dy[a];
            if (nx>=0 && ny>=0 && nx<N && ny<N) {
                if (visited[ny][nx]==false && region[ny][nx]>h) {
                    dfs(h,nx,ny);
                }
            }
        }
    }
}
