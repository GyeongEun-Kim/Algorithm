import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        //3:08
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);//세로
        int w = Integer.parseInt(input[1]); //가로
        int block[] = new int[w];

        String[] b = br.readLine().split(" ");
        for (int i=0;i<w;i++) {
            block[i] = Integer.parseInt(b[i]);
        }//input

        int cnt=0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<block.length;i++) {
            int left =0;
            //현재 인덱스를 기준으로 왼쪽편에서 가장 큰 막대 길이
            for (int l=0;l<i;l++) {
                if (left<block[l] ) left=block[l];
            }
            int right =0;
            //현재 인덱스 기준으로 오른쪽에서 가장 큰 막대 길이
            for (int r=i+1;r<w;r++) {
                if (right<block[r]) right=block[r];
            }

            if (left> block[i] && right > block[i])
                cnt = cnt + (Math.min(left,right)-block[i]);

            }
        System.out.println(cnt);
    }
}
