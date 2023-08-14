import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] result;
    static boolean[] visit;
    //static int[][] map;
    static List<List<Integer>>  adList = new ArrayList<>();

    /**
     * 인접 행렬 사용시 메모리 초과.
     * -> 인접 리스트 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        visit= new boolean[n+1];
        //map= new int[n+1][n+1];
        result= new int[n+1];

        for (int i=0;i<=n;i++) {
            adList.add(new ArrayList<Integer>());
        }


        for (int i=1;i<n;i++) {
            String[] s = br.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);
            adList.get(first).add(second);
            adList.get(second).add(first);
//            map[first][second] = 1;
//            map[second][first] =1;
        }

        bfs(n);


        for (int i=2;i<=n;i++) {
            System.out.println(result[i]);
        }
    }

    public static void bfs (int n) {
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            Integer parent = queue.poll();
            for (int i=0;i<adList.get(parent).size();i++) {
                Integer a = adList.get(parent).get(i);
                if (visit[a]==false ) {
                    queue.offer(a);
                    visit[a] = true;
                    result[a] = parent;
                }
            }
        }
    }


}