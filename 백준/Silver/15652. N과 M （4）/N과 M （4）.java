import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        //1~N 까지의 자연수중에 M개의 자연수를 고룸
        //비 내림차순
        //같은 수 여러번 가능

        int[] arr = new int[m];


        backTrack(0, arr, m, n,1);

        List<String> result = new ArrayList<>(set);
        Collections.sort(result);

        for (String s : result) System.out.println(s.stripLeading());

    }
    public static void backTrack (int cnt, int[] arr, int m, int n, int last) {
        if(cnt==m) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) sb.append(i).append(" ");
            System.out.println(sb.toString());
            return ;
        }

        for (int i=last;i<=n;i++) {
            arr[cnt] = i;
            backTrack(cnt+1,arr,m,n ,i);
        }


    }

 }
