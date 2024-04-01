import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); //이번학기가 몇분인지
    Stack<int[]> stack = new Stack<>();
    int score = 0;
    int perfect = 0; //현재하고 있는 과제의 만점
    int left = 0; //현재 하고 있는 과제가 얼마나 남았는지
    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      if (str[0].equals("1")) {
        if (left > 0) { //현재 하고 있는 과제가 있으면 큐에 넣고 바로 다른 과제 시작
          stack.push(new int[]{perfect, left});
        }
        perfect = Integer.parseInt(str[1]);
        left = Integer.parseInt(str[2]) - 1;
      } else {
        if (left > 0) { //현재 하고 있는 과제가 아직 남은경우
          left--;
        } else { //현재 하고 있는 과제가 없는 경우 큐에서 꺼내서 한다.
          if (!stack.isEmpty()) {
            int[] poll = stack.pop();
            perfect = poll[0];
            left = poll[1] - 1;
          }
        }
      }
      if (left == 0) {
        score += perfect;
        perfect = 0;
      }

    }

    System.out.println(score);
  }

}
