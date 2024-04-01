import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int result = 0;
  static int n;
  static int[] dx = {0, -1, 1, 0};
  static int[] dy = {-1, 0, 0, 1};
  static int[][] map;
  static int size = 2; //아기상어의 크기
  static int ate = 0;
  static Point start;
  static boolean movable = true;
  static boolean eat = true;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] l = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int status = Integer.parseInt(l[j]);
        map[i][j] = status;
        if (status == 9) {
          start = new Point(j, i);
        }
      }
    }

    while (eat == true) {
      bfs(start);
    }

    System.out.println(result);

  }

  public static void bfs(Point shark) {
    Integer[][] visit = new Integer[n][n];
    Queue<Point> queue = new LinkedList<>();
    queue.add(shark);
    visit[shark.y][shark.x] = 0;
    movable = false;

    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
          if (visit[ny][nx] == null && map[ny][nx] <= size) {

            visit[ny][nx] = visit[cur.y][cur.x] + 1;

            queue.add(new Point(nx, ny));
            movable = true;
          }
        }
      }
    }

    if (movable) {
      findShortest(visit, shark);
    } else {
      eat = false;
    }


  }

  public static void findShortest(Integer[][] visit, Point shark) {
    int shortest = 999999999;
    Point loc = null;
    eat = false;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visit[i][j] != null && shortest > visit[i][j] && map[i][j] < size && map[i][j] != 0) {
          //1. 안가본 칸 (null이면 안된다)
          //2. 더 가까운칸 (어짜피 왼쪽위부터 탐색하기때문에 거리만 보면됨)
          //3. 현재 아기상어의 몸집보다 작아야 먹을 수 있다.
          //4. 현재 아기상어가 있는 칸은 0이므로 패스

          shortest = visit[i][j];
          loc = new Point(j, i);
        }
      }
    }

    if (loc != null) { //먹을 수 있음
      ate++;
      if (ate == size) {
        ate = 0;
        size++;
      }
      result += shortest;

      //새로운 아기 상어의 자리 9로
      map[loc.y][loc.x] = 9;
      //아기 상어가 있던 자리 0으로
      map[shark.y][shark.x] = 0;
      start = new Point(loc.x, loc.y);
      eat = true;
    }

  }

}
