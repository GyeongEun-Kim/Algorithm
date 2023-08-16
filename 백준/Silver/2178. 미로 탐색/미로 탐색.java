import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;
public class Main {
   // static int cnt=1;
    static boolean visited[][];
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1, 0,0};
    static int N,M;
    static int[][] maze;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]); //세로
        M = Integer.parseInt(temp[1]); //가로
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<M;j++) {
                maze[i][j] = s.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(maze[N-1][M-1]);
    }

    public static void bfs(int i, int j) {
        queue.add(new Point(i,j));
        visited[j][i] = true;
        outLoop :
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int h=0;h<4;h++) {
                int nx= current.x+dx[h];
                int ny = current.y+dy[h];
//                if (nx==M-1 && ny==N-1) {
//                    break outLoop;
//                }
                if (nx>=0 && ny>=0 && nx<M && ny<N) {
                    if (visited[ny][nx]==false && maze[ny][nx]==1){
                        visited[ny][nx]=true;
                        queue.add(new Point(nx,ny));
                        maze[ny][nx]=maze[current.y][current.x]+1;
                        //cnt++;
                      //  System.out.println(queue.peek().x+" "+queue.peek().y);
                    }
                }

            }
        }

    }
}
