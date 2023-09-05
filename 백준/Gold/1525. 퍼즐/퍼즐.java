import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[] dx ={0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static  int answer =Integer.MAX_VALUE;
    static Map<String,Integer> map ;
    public static void main(String[] args) throws IOException {
        //3:36
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map= new HashMap<>();
        for (int i=0;i<3;i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0;j<3;j++) {
                if (line[j].equals("0")) sb.append("9");
                else sb.append(line[j]);
                }
        }//input

        map.put(sb.toString(),0);
        bfs(sb.toString());

        if (map.containsKey("123456789")) System.out.println(map.get("123456789"));
        else System.out.println(-1);
    }

    public static void bfs (String str) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(str);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            //9의 인덱스를 찾음
            int idx = cur.indexOf("9");
            int y = idx/3; //9가 위치하는 곳의 y좌표
            int x = idx%3; //9가 위치하는 곳의 x좌표
            for (int i=0;i<4;i++) {
                int nx = x + dx[i]; //움직일 곳의 x좌표
                int ny = y+ dy[i]; //움직일 곳의 y좌표
                if (nx>=0 && ny>=0 && nx<3 && ny<3) {
                    char move = cur.charAt(3*ny + nx); //움직일 곳에 있는 숫자
                    StringBuilder swap = new StringBuilder(cur);
                    swap.setCharAt(3*ny+nx, '9');
                    swap.setCharAt(idx,move);

                    if (!map.containsKey(swap.toString())) {
                        map.put(swap.toString(), map.get(cur) + 1);
                        queue.offer(swap.toString());
                    }
                }
            }
        }
    }

//    public static void swap(Point s, Point e)  {
//        int temp = map[s.y][s.x] ;
//        map[s.y][s.x] = map[e.y][e.x];
//        map[e.y][e.x] = temp;
//    }

    // swap이 이루어져야해서 백트래킹으로 dfs구현을 생각했는데 이렇게 하면 visit때문에 최대깊이가 8밖애 안됨.
//    public static void dfs (int x, int y, int cnt) {
//
//        if (x==2 && y==2) {
//            boolean flag = false;
//            for (int i=0;i<3;i++) {
//                for (int j=0;j<3;j++) {
//                    if(i==2 && j==2) continue;
//                    if (map[i][j]!= 3*i + j+1) {
//                        flag=true;
//                    }
//
//                }
//            }
//            if (flag==false) answer=Math.min(cnt,answer);
//            return;
//        }
//
//        for (int i=0;i<4;i++) {
//            int nx = x+dx[i];
//            int ny = y + dy[i];
//            if (nx>=0 && ny>=0 && nx<3 && ny<3 && visit[ny][nx]==false) {
//                visit[ny][nx] = true;
//                swap(new Point(x,y), new Point(nx,ny));
//                dfs(nx, ny, cnt+1);
//                visit[ny][nx] = false;
//                swap(new Point(x,y), new Point(nx,ny));
//            }
//        }
//
//
//    }

}
