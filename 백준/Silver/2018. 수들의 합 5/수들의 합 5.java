import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = i;
    }
    int result = 0;
    int start = 1;
    int end = 1;
    int sum = 1;

    while (start <= end) {
      //System.out.println("result = " + result);
      //System.out.println("sum = " + sum);
      if (sum == n) {
        result++;
      }
      if (sum <= n) {
        end++;
        if (end > n) {
          break;
        }
        sum += arr[end];
      } else {
        sum -= arr[start];
        start++;
      }
    }

    System.out.println(result);

  }

}
