import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //7:41시작
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=0;i<tc;i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            List<List<Integer>> list = new ArrayList<>();
            for (int j=0;j<26;j++)  list.add(new ArrayList<Integer>());

            for (int j=0;j<str.length();j++) {
                int alphabet = str.charAt(j)-'a';
                list.get(alphabet).add(j);
            }

            int shortest=Integer.MAX_VALUE;
            int longest =0;
            int len =0;
            for (int j=0;j< list.size();j++) {
                List<Integer> cur = list.get(j);
                if (cur.size()>=k) {
                   for (int p=0;p<=cur.size()-k;p++) {
                       len = cur.get(p+k-1) - cur.get(p)+1;
                       shortest=Math.min(shortest,len);
                       longest=Math.max(longest,len);
                   }
                }

            }

            if (shortest==Integer.MAX_VALUE && longest==0) System.out.println(-1);
            else System.out.println(shortest+" "+longest);


        }

    }
}
