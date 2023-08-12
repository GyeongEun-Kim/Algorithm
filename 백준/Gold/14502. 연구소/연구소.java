import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class Main {
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {-1,1,0,0};
    public static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]); //세로
        int M = Integer.parseInt(size[1]); //가로

        int[][] map = new int[N][M];


        for (int i=0;i<N;i++) {
            String line[] = br.readLine().split(" ");
            for (int j=0;j<M;j++) {
                map[i][j]= Integer.parseInt(line[j]);
            }
        }


        combination(map, 0,3); //벽세우기


        System.out.println(cnt);

    }
    //벽을 둘 3개를 어떻게 정하지?
    //최대 경우의수 64C3 -> 약 4만 번 bfs를 돌린다.
    public static void bfs(int[][] map) {
        int[][] virusMap = new int[map.length][map[0].length];
        for (int n=0;n< map.length;n++) {
            virusMap[n] = map[n].clone();
        }
        Queue<Point> queue = new LinkedList<>();
        boolean[][] spread = new boolean[map.length][map[0].length];


        for (int i=0;i<virusMap.length;i++) {
            for (int j=0;j<virusMap[0].length;j++) {
                if (virusMap[i][j]==2) {
                    queue.offer(new Point(j,i));
                    spread[i][j] = true;
                }
            }
        }


        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0;i<4;i++) {
                int nx= cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0 && nx<map[0].length && ny>=0 && ny< map.length) {
                    if (virusMap[ny][nx]==0 && spread[ny][nx]== false) {
                        virusMap[ny][nx]=2;
                        spread[ny][nx] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        count(virusMap);

    }

    public static void count (int[][] map) {
        int tempCnt =0;
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[0].length;j++) {
                if (map[i][j]==0) {
                    tempCnt ++;
                }
            }
        }
        //System.out.println("tempCnt = " + tempCnt);
        cnt = Math.max(cnt, tempCnt);
       // System.out.println("cnt = " + cnt);
    }

    public static void combination (int[][] map, int depth, int r) {
        //backtracking
        if (depth==r) {
            bfs(map);
            return ;
        }
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[0].length;j++) {
                if (map[i][j]==0) {
                    map[i][j] = 1; //벽세우기
                    combination(map, depth + 1, r);
                    map[i][j] = 0;
                }
            }
        }

    }
}
