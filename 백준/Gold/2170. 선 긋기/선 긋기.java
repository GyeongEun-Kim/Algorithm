import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //int[][] draw = new int[n][2];
        List<int[]> draw = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int[] points = new int[2];
            points[0] = Integer.parseInt(line[0]);
            points[1] = Integer.parseInt(line[1]);
            draw.add(points);
        }//input

        Collections.sort(draw, (o1, o2)-> o1[0]-o2[0]);

        answer+=draw.get(0)[1]-draw.get(0)[0];
        int end = draw.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (draw.get(i)[0] <= end) {
                if (draw.get(i)[1] <end) continue;
                answer += draw.get(i)[1] - end;
            }
            else  {
                answer+= draw.get(i)[1] - draw.get(i)[0];
            }
            end = Math.max(end, draw.get(i)[1]);

        }


        System.out.println(answer);
    }
}