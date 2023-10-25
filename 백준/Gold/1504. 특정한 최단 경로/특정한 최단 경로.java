import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int[][] graph;
    static final int MAX = 2000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);


        graph = new int[n+1][n+1];

        for (int i=0;i<e;i++) {
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph[n1][n2] = w;
            graph[n2][n1] = w;
        }
        String must[] = br.readLine().split(" ");
        int m1 = Integer.parseInt(must[0]);
        int m2 = Integer.parseInt(must[1]);

        long route1 = dijkstra(1,m1) + dijkstra(m1,m2) + dijkstra(m2,n);
        long route2 = dijkstra(1,m2) + dijkstra(m2,m1) + dijkstra(m1,n);
//        System.out.println("route1 = " + route1);
//        System.out.println("route2 = " + route2);
        long result = route1>=MAX && route2>=MAX ? -1 : Math.min(route1,route2);
        System.out.println(result);
    }
    public static long dijkstra (int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1] ); //현재 노드, 비용
        //비용순 정렬
        int[] cost = new int[n+1];
        Arrays.fill(cost,MAX);
        cost[start]=0;
        pq.add(new int[] {start,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            //if (cur[1] > cost[cur[0]]) continue;

            for (int i=1;i<=n;i++) {
                if (graph[cur[0]][i]!=0) {//두 노드가 이어져 있으먄
                    if (cur[1] + graph[cur[0]][i] < cost[i]) {
                        pq.add(new int[]{i,cur[1] + graph[cur[0]][i]});
                        cost[i] = cur[1] + graph[cur[0]][i];
                    }
                }
            }
        }
        return cost[end];

    }

}
