import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int tomatoes[][][];
    static int visited[][][];
    static int dx[] = {0,0,-1,1,0,0};
    static int dy[] ={-1,1,0,0,0,0};
    static int dz[] ={0,0,0,0,-1,1};
    static int N,M,H;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        M= Integer.parseInt(size[0]); //가로
        N = Integer.parseInt(size[1]); //세로
        H =Integer.parseInt(size[2]); //높이

        tomatoes=new int[N][M][H];
        visited = new int[N][M][H];
        Point start=new Point(0,0,0);
        for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++) {
                String s[] = br.readLine().split(" ");
                for (int k=0;k<M;k++) {
                    tomatoes[j][k][i]= Integer.parseInt(s[k]);
                    if (tomatoes[j][k][i]==1) {
                        visited[j][k][i] =1;
                        start=new Point(k,j,i);
                        queue.add(start);
                    }
                    else if (tomatoes[j][k][i]==-1) {
                        visited[j][k][i]=-1;
                    }
                }
            }
        }



//        for (int i=0;i<H;i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(visited[j][k][i]);
//                }
//                System.out.println();
//            }
//        }



        Point result = bfs(start.x, start.y, start.z);
        int max = Integer.MIN_VALUE;
        boolean check = false;

        outLoop :
        for (int i=0;i<H;i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (visited[j][k][i] == 0) {
                        check = true;
                        break outLoop;
                    }
                }
            }
        }

        if (check)
            System.out.println(-1);
        else
            System.out.println(visited[result.y][result.x][result.z]-1);


    }

    static class Point {
        int x,y,z;
        public Point(int x, int y, int z) {
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }

    static Point bfs(int x, int y, int z) {

        Point current= new Point(0,0,0);
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int t=0;t<6;t++) {
                int nx= current.x+dx[t];
                int ny= current.y+dy[t];
                int nz= current.z+dz[t];
                if (nx>=0 && ny>=0 && nz>=0 && nx<M && ny<N && nz<H) {
                    if (visited[ny][nx][nz]==0) {
                        visited[ny][nx][nz] = visited[current.y][current.x][current.z]+1;
                        queue.add(new Point(nx,ny,nz));
                    }
                }
            }
        }
        return current;
    }
}
