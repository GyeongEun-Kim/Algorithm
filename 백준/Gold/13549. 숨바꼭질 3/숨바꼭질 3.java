import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); //언니 위치
        int m = Integer.parseInt(input[1]); //동생 위치
        loc = new int[100001];
        dijkstra(n,m);
        System.out.println(loc[m]);

    }

    public static void dijkstra (int n, int m) {
        Arrays.fill(loc, Integer.MAX_VALUE); //초기값 무한대로
        loc[n] = 0;// 시작 지점
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //현재 위치, 누적 시간
        pq.add(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (loc[cur[0]] < cur[1]) continue;

            int ahead = cur[0] + 1; //한칸 앞
            if (ahead >= 0 && ahead <= 100000) {
                if (cur[1] + 1 < loc[ahead]) {
                    loc[ahead] = cur[1] + 1;
                    pq.add(new int[]{ahead, cur[1] + 1});
                }
            }
            int back = cur[0] - 1; //한칸 뒤
            if (back >= 0 && back <= 100000) {
                if (cur[1] < loc[back]) {
                    loc[back] = cur[1] + 1;
                    pq.add(new int[]{back, cur[1] + 1});
                }
            }
            int multiple = cur[0] * 2; //두배 앞으로
            if (multiple >= 0 && multiple <= 100000) {
                if (cur[1] < loc[multiple]) {
                    loc[multiple] = cur[1];
                    pq.add(new int[]{multiple, cur[1]});
                }
            }

        }
    }
}
