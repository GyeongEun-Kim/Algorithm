import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean movable = true;

    static int N,L,R;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]);
        L = Integer.parseInt(str1[1]);
        R = Integer.parseInt(str1[2]);

        map = new int[N][N];

        int result = 0;

        for (int i=0;i<N;i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (movable == true) {
            movable = false;
            result++;
            visit= new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == false)
                        bfs(j, i);
                }
            }
        }

        System.out.println(result-1);



    }

    public static void bfs (int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visit[y][x] = true;
        List<Point> union = new ArrayList<>(); //연합인 국가를 담는 리스트
        union.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i=0;i<4;i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (nx>=0 && ny>=0 && nx<N && ny<N) {
                    if (visit[ny][nx] == false && compare(cur, new Point(nx,ny))) {

                        queue.add(new Point(nx,ny));
                        visit[ny][nx] = true;
                        union.add(new Point(nx,ny));
                        movable= true;
                    }
                }

            }
        }

        move(union);
    }

    public static boolean compare (Point cur, Point next) {
        int sub = Math.abs(map[cur.y][cur.x] - map[next.y][next.x]);
        //System.out.println("sub = " + sub);
        if (sub>= L && sub<=R) return true;
        else return false;
    }

    public static void move(List<Point> union) {
        int cnt = union.size();
        if (cnt==0) return ;
        int sum =0;

        for (int i=0;i<cnt;i++) {
            Point p = union.get(i);
            sum += map[p.y][p.x];
        }

        int avg = sum/cnt;

        for (int i=0;i<cnt;i++) {
            Point p = union.get(i);
            map[p.y][p.x] = avg;
        }

    }
}
