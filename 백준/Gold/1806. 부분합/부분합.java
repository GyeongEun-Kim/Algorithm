import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int S = Integer.parseInt(nums[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int start =0;
        int end =0;
        int sum =0;
        int len = Integer.MAX_VALUE;
        while (true) {
            if (end >= arr.length &&  start>= arr.length) {
                break;
            }
            if (sum <S) {
                //System.out.println("start = " + start);
                //System.out.println("end = " + end);
                if (end>=arr.length)
                    break;
                sum = sum + arr[end];
                end ++;
            }
            else {
                len = Math.min(len, end-start);
                sum = sum - arr[start];
                start++;
            }
        }

        if (len == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(len);


    }
}
