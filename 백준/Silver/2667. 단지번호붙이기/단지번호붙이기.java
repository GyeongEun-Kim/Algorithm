import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    /**
     * x좌표와 y좌표 순서 주의하기...!!!!
     */
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map= new int[n][n];
        visited = new boolean[n][n];

        for (int i=0;i<n;i++) {
            String line = br.readLine();
            for (int j=0;j<n;j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }



        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (visited[i][j]==false && map[i][j]==1) {
                    bfs(j,i,n);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int h : result) {
            System.out.println(h);
        }
    }

    public static void bfs (int x , int y, int n) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[y][x] = true;
        int house =1; //한 단지에 속하는 집의 수

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i=0;i<4;i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(visited[ny][nx]==false && map[ny][nx]==1) {

                        queue.offer(new Point(nx, ny));
                        visited[ny][nx] = true;
                        house++;
                    }
                }
            }
        }
        result.add(house);
    }
}
