import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i=0;i<n;i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }//input

        for (int i=0;i<n;i++) {
            boolean[] visit = new boolean[n];
            visit[i] = true;
            backTrack( visit, i,0,0,i);
        }

        System.out.println(answer);
    }

    public static void backTrack (boolean[] visit, int start, int cnt, int sum, int next) {
        //System.out.println("sum = " + sum);
        if (cnt == n-1) {
            if (map[next][start]==0) return ;
            answer= Math.min(answer,sum + map[next][start]);
            return ;
        }

        for (int i=0;i<n;i++) {
            if (visit[i]==false && map[next][i]!=0) {
                visit[i] =true;
                backTrack( visit, start, cnt+1, sum+map[next][i], i);
                visit[i] = false;
            }
        }


    }
}