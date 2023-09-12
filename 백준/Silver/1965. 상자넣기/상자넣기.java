import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int size[] = new int[n];
        for (int i=0;i<n;i++) {
            size[i] =Integer.parseInt(input[i]);
        } //input

        int[] box = new int[n];
        Arrays.fill(box,1);

        for (int i=0;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (size[i] > size[j]) {
                    box[i] = Math.max(box[i], box[j]+1);
                }
            }
        }
        
        Arrays.sort(box);
        System.out.println(box[box.length-1]);
    }
}
