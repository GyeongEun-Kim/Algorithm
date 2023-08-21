import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean visited[][];
    static int[] forward_dx = {0,1,0,-1};
    static int[] forward_dy= {-1,0,1,0};
    //북 동 남 서 (북부터 시계방향)
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n= Integer.parseInt(s[0]); //세로
        int m = Integer.parseInt(s[1]); //가로
        String[] st = br.readLine().split(" ");
        int startX = Integer.parseInt(st[1]);
        int startY = Integer.parseInt(st[0]);
        int face = Integer.parseInt(st[2]);

        int[][] map = new int[n][m];
        for (int i=0;i<n;i++) {
            String line[] = br.readLine().split(" ");
            for (int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited = new boolean[n][m];
        bfs(map, startX, startY, n, m, face);
        System.out.println(answer);

    }

    public static void bfs(int[][] map, int x ,int y, int n , int m, int face) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[y][x] = true;
        int direction =face;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (map[cur.y][cur.x]==0) {
                //현재 칸이 청소되지 않았으면 청소하기
                answer++;
                map[cur.y][cur.x] =-1; //청소 했다는 의미
            }
            boolean clean =false;
            for (int i=0;i<4;i++) {
                direction = rotate(direction);//반시계회전
                int nx = cur.x + forward_dx[direction];
                int ny = cur.y + forward_dy[direction];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (visited[ny][nx] == false && map[ny][nx] == 0) {
                        //네 방향중 청소할 수 있는 칸이 있는 경우
                        //90도 반시계 회전후 앞 칸이 청소가능하면 전진
                        queue.offer(new Point(nx, ny));
                        visited[ny][nx] = true;
                        clean=true; //네 방향중 청소할 수 있는 칸이 있음
                        break ; //전진
                    }
                }
            }
            //네 방향중 청소할 수 있는 칸이 없는 경우
            if(clean==false) {
                int backward = (direction+2)%4;
                int backX = cur.x+forward_dx[backward];
                int backY = cur.y+forward_dy[backward];
                if(backX <0 || backX>=m || backY<0 || backY>=n || map[backY][backX]==1) { //후진 못하면 break
                    break;
                }
                queue.offer(new Point(backX, backY));
            }
            //방향 유지한채로 후진. 후진도 못하면 정지


        }
    }

    static int rotate (int face) {
        if (face==0) return 3;
        else return face-1;
    }
}