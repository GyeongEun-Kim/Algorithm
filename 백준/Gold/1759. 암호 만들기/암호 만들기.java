import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  static List<String> codes = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int l = Integer.parseInt(input[0]); //암호 길이
    int c = Integer.parseInt(input[1]); //암호에 사용된 알파벳의 후보
    String[] candidate = br.readLine().split(" ");
    Arrays.sort(candidate);

    backTrack(l, c, 0, "", candidate, 0);
    Collections.sort(codes);
    for (String code : codes) {
      System.out.println(code);
    }
  }

  public static void backTrack(int l, int c, int cnt, String str, String[] candidate, int start) {
    if (l == cnt) {
      if (checkMoeum(str)) {
        codes.add(str);
      }
      return;
    }

    for (int i = start; i < c; i++) {
      String temp = str;
      str = str + candidate[i];

      backTrack(l, c, cnt + 1, str, candidate, i + 1);
      str = temp;
    }
  }

  public static boolean checkMoeum(String str) {
    int totalLen = str.length();
    str = str.replace("a", "");
    str = str.replace("e", "");
    str = str.replace("i", "");
    str = str.replace("o", "");
    str = str.replace("u", "");

    int removeMoeumLem = str.length();
    int moeumLen = totalLen - removeMoeumLem;

    if (moeumLen >= 1 && removeMoeumLem >= 2) {
      return true;
    } else {
      return false;
    }
  }

}
