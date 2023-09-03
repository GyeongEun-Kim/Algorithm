import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int dx[] = {-1,1,0,0};
    static int dy[] ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] iceberg = new int[n][m];
        int max =0;
        for (int i = 0; i < n; i++) {
            String line[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Integer.parseInt(line[j]);
                max = Math.max(max, iceberg[i][j]);
            }
        }//input

        int answer = 0;
        int a =0;

        while (true) {
            boolean visit[][] = new boolean[n][m];
            int cnt = 0; //떨어져있는 빙하 갯수
            boolean flag = false;
            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if (iceberg[i][j] > 0 && visit[i][j] == false ) {
                        bfs(iceberg, visit, n, m, j, i);
                        cnt++;
                        flag=true;
                    }
                }
            }
//            for (int q=0;q<n;q++) {
//                for (int p=0;p<m;p++) {
//                    System.out.print(iceberg[q][p]);
//                }
//                System.out.println();
//            }
//            System.out.println("===");
            if (cnt >= 2) {
                answer = a;
                break;
            }
            
            if(flag == false) break; //다 녹을때까지 2개이상으로 분리 안되는 경우

            a++;

            boolean melt[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                            if (iceberg[ny][nx] == 0 && melt[ny][nx] == false && iceberg[i][j]-1 >=0) {
                                iceberg[i][j]--;
                                melt[i][j] = true;
                            }
                        }
                    }
                }
            }

    }

        System.out.println(answer);

    }

    public static void melt (int[][] map, int n, int m) {
        boolean visit[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (map[ny][nx] == 0 && visit[ny][nx] == false && map[i][j]-1 >=0) {
                            map[i][j]--;
                            visit[i][j] = true;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int[][]map, boolean[][] visit, int n, int m ,int x, int y ) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0;i<4;i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if (nx>=0 && ny>=0 && nx<m && ny<n) {
                    if (map[ny][nx] > 0 && visit[ny][nx]==false) {
                        queue.offer(new Point(nx,ny));
                        visit[ny][nx]=true;
                    }
                }
            }
        }

    }
}