import java.io.*;
import java.util.*;

public class Main {
    static boolean graph[][];
    static boolean dfsVisit[];
    static String dfsResult ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums[] = br.readLine().split(" ");
        int vertex = Integer.parseInt(nums[0]);
        int edge = Integer.parseInt(nums[1]);
        int start = Integer.parseInt(nums[2]);

        graph = new boolean[vertex+1][vertex+1];

        for (int i=0;i<edge;i++) {
            String s[] = br.readLine().split(" ");
            int first =Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);
            graph[first][second] = true;
            graph[second][first] = true;
        }

        dfsVisit = new boolean[vertex+1];

        dfs(graph, start, vertex, String.valueOf(start));
        System.out.println(dfsResult);

        System.out.println(bfs(graph,start, vertex));

    }

    public static void dfs(boolean graph[][], int start, int vertex, String output) {
        dfsVisit[start] = true;
        dfsResult= output;
        //System.out.println("dfsResult = " + dfsResult);

        for (int i=1;i<=vertex;i++) {
            if (dfsVisit[i]==false && graph[start][i]==true) {
                dfs(graph, i, vertex,dfsResult+" "+i);
            }
        }



    }
    public static String bfs(boolean graph[][], int start, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visit = new boolean[vertex+1];
        visit[start]=true;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur+" ");
            for (int i=1;i<=vertex;i++) {
                if (visit[i]==false && graph[cur][i]==true) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
        return sb.toString();
    }
}
