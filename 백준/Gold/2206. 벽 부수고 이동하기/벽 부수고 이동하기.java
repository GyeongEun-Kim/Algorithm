import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        //3:04 시작
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]); //세로
        int m = Integer.parseInt(size[1]); //가로
        int map[][] = new int[n][m];
        int visit[][][] = new int[n][m][2]; //visit[y좌표][x좌표][0] : 벽을 안뿌신 경우 visit[y좌표][x좌표][1] : 벽을 뿌신 경우
        for (int i=0;i<n;i++) {
            String line = br.readLine();
            for (int j=0;j<m;j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }//input

        bfs(map,visit,n,m);

        


        int nonBroken = visit[n-1][m-1][0];
        int broken =  visit[n-1][m-1][1];
        if (nonBroken==0 && broken==0) System.out.println(-1);
        else if (broken==0) System.out.println(nonBroken);
        else if (nonBroken==0) System.out.println(broken);
        else System.out.println((Math.min(nonBroken,broken)));
    }

    public static void bfs (int[][] map, int[][][] visit, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0}); //[y][x][벽을 부순적이 있는가?]
        visit[0][0][0] =1;
        visit[0][0][1] =1;

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (map[ny][nx]==0) { //빈칸일 때
                        if (visit[ny][nx][cur[2]]==0) {//현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                            visit[ny][nx][cur[2]] = visit[cur[1]][cur[0]][cur[2]] + 1;
                            queue.add(new int[]{nx, ny, cur[2]});
                        }
                    }
                    else { //벽인경우
                        if (cur[2]==0) {//지금까지 뿌신적 없는 경우
                            visit[ny][nx][1] = visit[cur[1]][cur[0]][0] +1;
                            queue.add(new int[] {nx,ny, 1});
                        }
                    }
                }
            }
        }
    }

}
