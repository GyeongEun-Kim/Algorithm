import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]); //점의 갯수
        int m = Integer.parseInt(nums[1]); //진행된 차례의 수
        root = new int[n];

        for (int i=0;i<n;i++) root[i]=i;

        boolean flag = false;
        for (int i=0;i<m;i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            int rx = find(x);
            int ry = find(y);
            if (rx!= ry) {
                root[rx] = ry;
            }
            else {
                System.out.println(i+1);
                flag= true;
                break;
            }
        }

        if (flag==false) System.out.println("0");




    }

    public static int find (int x) {
        if (root[x]==x) return x;
        root[x] = find(root[x]);
        return root[x];
    }

}