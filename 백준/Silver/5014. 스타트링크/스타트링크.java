import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        //1:34
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int f = Integer.parseInt(input[0]); //건물 총 층수
        int s= Integer.parseInt(input[1]); // 지금 있는 층수
        int g= Integer.parseInt(input[2]); //가야 하는 충수
        int u= Integer.parseInt(input[3]); //위로 u층
        int d= Integer.parseInt(input[4]); //아래로 d층

        Integer[] building = new Integer[f+1];



        bfs(building, s, f, u, d);
        if(building[g]!=null)  System.out.println(building[g]);
        else System.out.println("use the stairs");

    }

    public static void bfs (Integer[] building, int s, int f, int u, int d) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(s);
        building[s] =0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int i=0;i<2;i++) {
                int nx = cur;
                if(i==0) nx = nx+ u;
                else if (i==1) nx = nx- d;
                if (nx>=1 && nx<=f && building[nx]==null) {
                    building[nx] = building[cur]+1;
                    queue.add(nx);
                }
            }
        }
    }
}
