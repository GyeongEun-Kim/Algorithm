import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static Map<String, String> network;
    static Map<String, Integer> cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0;i<tc;i++) {
            int f = Integer.parseInt(br.readLine());
            network= new HashMap<>();
            cnt= new HashMap<>();
            for (int j=0;j<f;j++) {

                String s[] = br.readLine().split(" ");
                String f1 = s[0];
                String f2 = s[1];

                network.putIfAbsent(f1,f1);
                network.putIfAbsent(f2,f2); //초기화

                union(f1,f2);

            }

    }

}
    public static void union (String x, String y) {
        String px = find(x);
        String py = find(y);
        if(!px.equals(py)) {
            network.put(py,px);
            cnt.put(px,cnt.getOrDefault(find(px),1)+cnt.getOrDefault(py,1));
        }
        System.out.println(cnt.get(find(px)));


    }

    public static String find(String x) {
        if (network.get(x).equals(x)) return x;
        else {
            network.put(x,find(network.get(x)));
            return network.get(x);
        }
    }
}
