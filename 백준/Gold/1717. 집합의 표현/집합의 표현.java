import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        root = new int[n+1];
        for (int i=0;i<=n;i++) {
            root[i]=i;
        }

        for (int i=0;i<m;i++) {
            String c[] = br.readLine().split(" ");
            int cal = Integer.parseInt(c[0]);
            int first = Integer.parseInt(c[1]);
            int second =Integer.parseInt(c[2]);

            if (cal==0) {//union
                union(first,second);
            }
            else if (cal==1) {//find
                if (find(first)== find(second)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px!=py) {
            root[py]=px;
        }
    }

    public static int find(int x) {
        if(root[x]==x) return x;
        else {
            root[x] = find(root[x]);
            return root[x];
        }
    }
}
