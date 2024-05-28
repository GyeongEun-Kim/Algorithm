import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int l = Integer.parseInt(input[1]); //슬라이딩 윈도우의 크기
    String[] str = br.readLine().split(" ");

    Deque<int[]> deq = new ArrayDeque<>(); // [0]: 실제값, [1]: 인덱스

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(str[i]);
      while (!deq.isEmpty() && deq.peekLast()[0] > num) {
        deq.pollLast();
      }

      deq.offer(new int[]{num, i});
      if (deq.peek()[1] < i - (l - 1)) {
        deq.poll();
      }
      sb.append(deq.peek()[0]);
      sb.append(" ");
    }

    System.out.println(sb.toString());


  }

}
