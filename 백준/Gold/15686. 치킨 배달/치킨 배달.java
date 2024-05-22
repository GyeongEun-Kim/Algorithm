import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int min = Integer.MAX_VALUE;
  static List<Point> chicken = new ArrayList<>(); //원래 치킨집 위치 저장 리스트
  static List<Point> house = new ArrayList<>(); //집 위치 저장 리스트
  static boolean[] visit; //폐업시키지 않을 치킨집 저장 리스트

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]); //남길 치킨집 갯수

    for (int i = 1; i <= n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 1; j <= n; j++) {
        if (line[j - 1].equals("1")) {
          house.add(new Point(j, i));
        } else if (line[j - 1].equals("2")) {
          chicken.add(new Point(j, i));
        }
      }
    } //input

    visit = new boolean[chicken.size()];

    /**
     * 1. 조합으로 남길 치킨집 고르기
     * 2. 각 조합마다 치킨거리 구하기
     */

    combination(m, 0, 0);
    System.out.println(min);

  }

  public static void combination(int m, int cnt, int start) {
    if (m == cnt) {
      //치킨 거리 구하기
      int total = 0;
      for (int i = 0; i < house.size(); i++) {
        int distance = Integer.MAX_VALUE;
        for (int j = 0; j < chicken.size(); j++) {
          if (visit[j] == true) {
            Point h = house.get(i);
            Point c = chicken.get(j);
            distance = Math.min(distance, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
          }
        }
        //System.out.println(i + "번집의 치킨거리= " + distance);
        total += distance;
      }
      min = Math.min(min, total);
      return;
    }

    for (int i = start; i < chicken.size(); i++) {
      visit[i] = true;
      combination(m, cnt + 1, i + 1);
      visit[i] = false;
    }

  }


}
