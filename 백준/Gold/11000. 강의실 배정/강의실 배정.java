import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            lecture[i][0] = Integer.parseInt(input[0]);
            lecture[i][1] = Integer.parseInt(input[1]);
        }//input

        Arrays.sort(lecture, (o1,o2)-> o1[0]-o2[0]); //시작 시간 오름차순 정렬

        for (int i=0;i<n;i++) {
            if (pq.isEmpty() || pq.peek()> lecture[i][0]) {
                pq.offer(lecture[i][1]);
            }
            else if (pq.peek()<= lecture[i][0]) {
                pq.poll();
                pq.offer(lecture[i][1]);
            }
        }
        System.out.println(pq.size());

    }
}
