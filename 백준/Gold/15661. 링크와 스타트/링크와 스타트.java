import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean visit[];
    public static int n;
    public static int min=Integer.MAX_VALUE;
    public static List<Integer> linkTeam = new ArrayList<>();
    public static List<Integer> startTeam ;

    public static int[][] ability ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        visit = new boolean[n];

        for (int i=0;i<n;i++) {
            String str[] = br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                ability[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i=1;i<n;i++)
            backTrack(i, 0, 0);

        System.out.println(min);

    }

    //링크팀만 기준으로 생각하기
    public static void backTrack (int target, int choose, int index) {
        if (choose == target){
            getStartTeam();
            getScore();
            return ;
        }
        for (int i=index;i<n;i++) {
            if (visit[i] == false) {
                linkTeam.add(i);
                visit[i] = true;
                backTrack(target, choose+1, i);
                visit[i] = false;
                linkTeam.remove((Object)i);
            }
        }
    }

    public static void getScore () {
        int linkScore =0;
        int startScore =0;
//        System.out.println(linkTeam);
//        System.out.println(startTeam);

        int linkSize = linkTeam.size();
        int startSize = n - linkSize;

        for (int i=0;i<linkSize-1;i++) {
            for (int j=i+1;j<linkSize;j++) {
                int h = linkTeam.get(i);
                int y = linkTeam.get(j);
                linkScore = linkScore + ability[h][y] + ability[y][h];
            }
        }

        for (int i=0;i<startSize-1;i++) {
            for (int j=i+1;j<startSize;j++) {
                int h = startTeam.get(i);
                int y = startTeam.get(j);
                startScore = startScore + ability[h][y] + ability[y][h];
            }
        }
//
//        System.out.println("linkScore = " + linkScore);
//        System.out.println("startScore = " + startScore);

        min = Math.min(min, Math.abs(linkScore-startScore));

    }

    public static void getStartTeam () {
        startTeam = new ArrayList<>();
        for (int i=0;i<n;i++) {
            if(!visit[i]) startTeam.add(i);
        }
    }
}

/**
 * 1,3 4 // 2
 *
 *
 * 4
 * 0 1 2 3
 * 4 0 5 6
 * 7 1 0 2
 * 3 4 5 0
 */
