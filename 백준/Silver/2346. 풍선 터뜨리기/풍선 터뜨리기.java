import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");
    Deque<int[]> deque = new ArrayDeque<int[]>(); // [0] : 인덱스, [1] : 풍선 안 실제 값

    for (int i = 1; i <= n; i++) {
      deque.offerFirst(new int[]{i, Integer.parseInt(input[i - 1])});
    } //input

    StringBuilder sb = new StringBuilder();

    /**
     * 음수인 경우, 양수인 경우 나눠서 생각하기
     * 양수인 경우 : last 에서 poll
     * 음수인 경우 : front 에서 poll
     * front에서 offer
     */

    int[] poll = deque.pollLast();
    int move = poll[1];
    sb.append(poll[0]);
    sb.append(" ");

    while (!deque.isEmpty()) {
      if (move > 0) {
        for (int i = 0; i < move - 1; i++) {
          deque.offerFirst(deque.pollLast());
        }
        poll = deque.pollLast();
      } else {
        for (int i = 0; i < Math.abs(move) - 1; i++) {
          deque.offerLast(deque.pollFirst());
        }
        poll = deque.pollFirst();
      }

      move = poll[1];

      sb.append(poll[0]);
      sb.append(" ");
    }

    System.out.println(sb.toString());
  }

}
