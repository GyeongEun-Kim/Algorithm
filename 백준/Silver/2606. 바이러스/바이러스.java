
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;
    static int cnt=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge= Integer.parseInt(br.readLine());

        list = new ArrayList[vertex+1];

        for (int i=0;i<vertex+1;i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i=0;i<edge;i++) {
            String temp[] = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list[v].add(u);
        }
        isVisited = new boolean[vertex+1];
        dfs(1);
        System.out.println(cnt);
    }

    static private void dfs(int x) {
        if (isVisited[x]) {
            return;
        }
        isVisited[x] = true;
        cnt++;
        for (int y : list[x]) {
            if (!isVisited[y])
                dfs(y);
        }
    }

}
