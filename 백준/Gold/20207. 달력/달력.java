import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] schedule = new int[366];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            for (int j = s; j <= e; j++) {
                schedule[j] += 1;
            }
        }

        int width = 0;
        int height = 0;
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] != 0) {
                width++;
                height = Math.max(height, schedule[i]);
            } else if (schedule[i] == 0) {
                answer += width * height;
                width = 0;
                height = 0;
            }
        }

        System.out.println(answer+width*height);

    }
}
