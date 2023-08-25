import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "YES";
        int n = Integer.parseInt(br.readLine());//도시의 수
        root= new int[n+1];
        for (int i=1;i<=n;i++) {
            root[i]=i;
        }
        int m = Integer.parseInt(br.readLine()); //여행계획에 속한 도시의 수
        for (int i=0;i<n;i++) {
            String line[] = br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                if(line[j].equals("1")) {
                    union(i+1, j+1);
                }
            }
        }
        String travel[] = br.readLine().split(" "); //여행계획
        int start = find(Integer.parseInt(travel[0]));
        for (String s: travel) {
            if (find(Integer.parseInt(s))!=start) {
                answer= "NO";
            }
        }
        System.out.println(answer);
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px<py){
            root[py] = px;
        }
    }
    public static int find(int x) {
        if(root[x]==x) return x;
        else {
            root[x]= find(root[x]);
            return root[x];
        }
    }
}
