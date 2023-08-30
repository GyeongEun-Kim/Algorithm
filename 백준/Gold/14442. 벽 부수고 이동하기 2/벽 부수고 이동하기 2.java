import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //5:03 시작
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        int[][][] visit = new int[n][m][k+1];

        for (int i=0;i<n;i++) {
            String line = br.readLine();
            for (int j=0;j<m;j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }//input

        bfs(map,visit,n,m,k);



        int min = Integer.MAX_VALUE;
        for (int i=0;i<=k;i++) {
            int now = visit[n-1][m-1][i];
            if (now==0) continue;
            if (now < min) min = now;
        }

        if (min== Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    public static void bfs (int[][] map, int[][][] visit, int n, int m, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {

                    if (map[ny][nx] == 0 && visit[ny][nx][cur[2]] == 0) { //빈칸인 경우
                        visit[ny][nx][cur[2]] = visit[cur[1]][cur[0]][cur[2]] + 1;
                        queue.offer(new int[]{nx, ny, cur[2]});
                    }
                    else { //벽인 경우, 뿌신횟수가 K이하면 뿌시기
                        if (cur[2] < k && visit[ny][nx][cur[2]+1] == 0) {


                            visit[ny][nx][cur[2] + 1] = visit[cur[1]][cur[0]][cur[2]] + 1;
                            queue.offer(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
//                    for (int q=0;q<n;q++) {
//                        for (int p=0;p<m;p++) {
//                            System.out.print(visit[q][p][1]);
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("---");
                }
            }
        }
    }

}
