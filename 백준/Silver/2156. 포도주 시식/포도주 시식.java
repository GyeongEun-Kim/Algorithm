import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] max = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    } //input

    if (n == 1) {
      System.out.println(arr[0]);
    } else if (n == 2) {
      System.out.println(arr[0] + arr[1]);
    } else {
      max[0] = arr[0];
      max[1] = arr[0] + arr[1];
      max[2] = Math.max(max[1], Math.max(arr[0], arr[1]) + arr[2]);

      for (int i = 3; i < n; i++) {
        max[i] = Math.max(max[i - 1],
            Math.max(max[i - 2] + arr[i], max[i - 3] + arr[i - 1] + arr[i]));
      }

      System.out.println(max[n - 1]);
    }
  }
  /**
   * 6 10 13 9 8 1
   *
   * 6, 10, 9, 8
   */

}
