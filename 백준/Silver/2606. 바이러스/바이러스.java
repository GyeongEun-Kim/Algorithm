
import java.io.*;
import java.util.*;

public class Main {
    /**
     * union-find로 풀어보기
     */
    static int[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        node = new int[computers+1];
        for (int i=1;i<=computers;i++) {
            node[i] = i;
        }

        for (int i=0;i<edge;i++) {
            String s[] = br.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);
            union(first, second);
        }

        int answer=0;
        for (int n=2;n<=computers;n++) {
            //System.out.println(node[n]);
            if (find(n)==find(1)) answer++;
        }
        System.out.println(answer);

    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX > rootY) {
            node[rootX] = rootY;
            node[x] = y;
        }
        else {
            node[rootY] = rootX;
            node[y] =x;
        }
    }
    public static int find(int x) {
        if (node[x]==x) return x;
        return node[x]= find(node[x]);

    }
}