import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //4:32
    static int[] dx ={0,0,-1,1};
    static int[] dy ={1,-1,0,0};
    static int[] horseX = {-2,-2,-1,-1,1,1,2,2};
    static int[] horseY = {-1,1,-2,2,-2,2,-1,1};
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String size[] = br.readLine().split(" ");
        int w = Integer.parseInt(size[0]); //가로
        int h = Integer.parseInt(size[1]); //세로

        int map[][] = new int[h][w];
        int move[][][] = new int[h][w][k+1]; //세로 가로 말처럼 움직인 횟수
        visit = new boolean[h][w][k+1];
        for (int i=0;i<h;i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0;j<w;j++) {
                    if (Integer.parseInt(line[j]) == 1) map[i][j] = -1;
                    else map[i][j] = Integer.parseInt(line[j]);
            }
        }//input

        bfs(map,move, w,h, k);


        int answer = Integer.MAX_VALUE;
        boolean flag = false; //최소값을 구하기 위한 플래그
        for (int i=0;i<=k;i++) {
            if (move[h-1][w-1][i]!= 0 && move[h-1][w-1][i] < answer) {
                answer = move[h-1][w-1][i];
                flag=true; //true면 최소값이 존재하는것
            }
        }
        if (flag == false) System.out.println(-1);
        else  System.out.println(answer-1);
    }

    public static void bfs (int[][] map, int[][][] move, int w, int h, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,0}); //x y 지금까지 찬스를 쓴 횟수
        visit[0][0][0] = true;
        move[0][0][0] =1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] +dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2];
                if (nx >= 0 && ny >= 0 && nx < w && ny < h && nz <= k) {
                    if (visit[ny][nx][nz] == false && map[ny][nx] == 0) {
                        move[ny][nx][nz] = move[cur[1]][cur[0]][cur[2]] + 1;
                        queue.offer(new int[] {nx,ny,nz});
                        visit[ny][nx][nz] = true;
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + horseX[i];
                int ny = cur[1] + horseY[i];
                int nz = cur[2] + 1;
                if (nx >= 0 && ny >= 0 && nx < w && ny < h && nz <= k ) {
                    if (visit[ny][nx][nz] == false && map[ny][nx] == 0 ) {
                        move[ny][nx][nz] = move[cur[1]][cur[0]][cur[2]] +1;
                        queue.offer(new int[] {nx,ny,nz});
                        visit[ny][nx][nz] = true;
                    }
                }
            }

        }
    }
}
