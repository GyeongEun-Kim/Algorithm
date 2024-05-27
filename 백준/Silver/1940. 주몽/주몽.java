import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int arr[] = new int[n];

    for (int i = 0; i < input.length; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    int start = 0;
    int end = n - 1;
    int result = 0;

    while (start < end) {
      int sum = arr[start] + arr[end];
      if (sum == m) {
        start++;
        end--;
        result++;
      } else if (sum < m) {
        start++;
      } else {
        end--;
      }
    }

    System.out.println(result);


  }

}

/**
 * 2 7 4 1 5 3 1 2 3 4 5 7
 */