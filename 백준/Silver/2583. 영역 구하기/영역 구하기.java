import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums[] = br.readLine().split(" ");
        int m = Integer.parseInt(nums[0]); //세로
        int n = Integer.parseInt(nums[1]); //가로
        int k = Integer.parseInt(nums[2]);

        map = new int[m][n];
        visited=new boolean[m][n];

        for (int i=0;i<k;i++) {
            String s[] = br.readLine().split(" ");
            Point left = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            Point right = new Point(Integer.parseInt(s[2]),Integer.parseInt(s[3]));
            fill(left,right);
        }

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (visited[i][j]==false && map[i][j]==0) {
                    int r = bfs(j, i, m, n);
                    if (r != 0) result.add(r);
                }
            }
        }

        Collections.sort(result);



        System.out.println(result.size());
        for (Integer i : result) {
            System.out.print(i+" ");
        }
    }

    public static int bfs(int x, int y, int m, int n) {
        Queue<Point> queue =new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[y][x] = true;
        int cnt =1;
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0;i<4;i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<m && visited[ny][nx]==false && map[ny][nx]!=1) {
                    visited[ny][nx] = true;
                    queue.offer(new Point(nx, ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void fill (Point left, Point right) {
        int startX = left.x;
        int endX = right.x;
        int startY = left.y;
        int endY = right.y;

        for (int i=startX;i<endX;i++) {
            for (int j=startY;j<endY;j++) {
                map[j][i] = 1;
            }
        }
    }
}
