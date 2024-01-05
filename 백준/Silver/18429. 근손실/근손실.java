import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] kit;
    static boolean[] check;
    static int n,k;
    static int answer =0;
    static int power = 500;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]); //며칠차까지
        k = Integer.parseInt(line[1]); //감소하는 중량

        kit = new int[n];
        check = new boolean[n];

        String[] str = br.readLine().split(" ");
        for (int i=0;i<str.length;i++) {
            kit[i] = Integer.parseInt(str[i]);
        } //input

        backTrack(0);
        System.out.println(answer);
    }

    public static void backTrack (int cnt) {
        if (cnt == n) {
            answer++;
            return ;
        }
        for (int i=0;i<n;i++) {
            if (power-k+kit[i] >=500 && check[i]==false) {
                check[i] = true;
                power = power-k+kit[i];
                backTrack(cnt+1);
                power = power+k-kit[i]; //원복
                check[i] = false;
            }
        }


    }
}
