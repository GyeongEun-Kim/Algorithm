import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        int vertex = Integer.parseInt(s[0]); //정점 갯수
        int edge = Integer.parseInt(s[1]); //간선 갯수
        int graph[][] = new int[edge][3];
        root = new int[vertex+1];

        for (int i=1;i<=vertex;i++) {
            root[i]=i;
        }

        for(int i=0;i<edge;i++) {
            String[] data =br.readLine().split(" ");
            int first = Integer.parseInt(data[0]);
            int second = Integer.parseInt(data[1]);
            int num = Integer.parseInt(data[2]); //가중치
            graph[i][0] = first;
            graph[i][1] = second;
            graph[i][2] = num;
        }

        Arrays.sort(graph,((o1, o2) -> {
            return o1[2] - o2[2];
        })); //가중치 오름차순으로 정렬

        long answer =0;
        for (int i=0;i<graph.length;i++) {
            int x =graph[i][0];
            int y=graph[i][1];
            int px = find(x);
            int py = find(y);
            if(px< py) {
                root[py]=px;
                answer+= graph[i][2];
            } //연결하고 answer에 가중치 더함
            else if (px> py) {
                root[px] = py;
                answer+=graph[i][2];
            }
        }
        System.out.println(answer);
    }


    public static int find(int x) {
        if (root[x]==x) return x;
        else {
            root[x]= find(root[x]);
            return root[x];
        }
    }
}
