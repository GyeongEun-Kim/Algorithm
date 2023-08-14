import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited= new boolean[n+1];
        answer = new int[n+1];

        String [] target = br.readLine().split(" ");
        int start = Integer.parseInt(target[0]);
        int end = Integer.parseInt(target[1]);

        int vertex = Integer.parseInt(br.readLine());

        List<List<Integer>> adList = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            adList.add(new ArrayList<>());
        }

        for (int i=0;i<vertex;i++) {
            String v[] = br.readLine().split(" ");
            int first = Integer.parseInt(v[0]);
            int second = Integer.parseInt(v[1]);
            adList.get(first).add(second);
            adList.get(second).add(first);

        }
        bfs(start, adList);

        if (answer[end]==0) System.out.println(-1);
        else System.out.println(answer[end]);

    }

    static void bfs(int start, List<List<Integer>> adList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] =true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i=0;i<adList.get(cur).size();i++) {
                Integer next = adList.get(cur).get(i);
                if (visited[next]==false) {
                    queue.offer(next);
                    answer[next]= answer[cur]+1;
                    visited[next]=true;
                }
            }
        }
    }
}
