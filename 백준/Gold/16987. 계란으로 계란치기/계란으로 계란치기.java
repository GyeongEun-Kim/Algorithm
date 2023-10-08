import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int egg;
    static int[][] eggInfo;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        egg = Integer.parseInt(br.readLine());
        eggInfo = new int[egg][2]; //내구도 무게
        for (int i=0;i<egg;i++) {
            String[] input = br.readLine().split(" ");
            int strength = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);
            eggInfo[i][0] = strength; //내구도
            eggInfo[i][1] = weight; //무게
        }

        backTrack(0);

        System.out.println(answer);


    }

    public static void backTrack(int start ) {
        if (start == egg) { //가장 오른쪾 달걀까지 다 집은경우
            int cnt = getCnt();
            answer=Math.max(answer, cnt);
            return ;
        }

        if (eggInfo[start][0]<=0) { //집은 달걀이 깨져 있는 경우 다음달걀을 집음
            while (start< egg &&  eggInfo[start][0]<=0) {
                if (eggInfo[start][0]<=0)
                    start++;
            }
            if (start>= egg) {
                int cnt = getCnt();
                answer=Math.max(answer, cnt);
                return ;
            }
        }

        for (int i=0;i<egg;i++) {
            if (i == start)continue;
            if (eggInfo[i][0] >0) { //깨지지 않은 계란 중에 하나를 친다.
                eggInfo[i][0] -= eggInfo[start][1];
                eggInfo[start][0] -= eggInfo[i][1];
                backTrack(start + 1);
                eggInfo[i][0] += eggInfo[start][1];
                eggInfo[start][0] += eggInfo[i][1];
            }
        }

        int cnt = getCnt();
        answer=Math.max(answer, cnt);

    }


    public static int getCnt() {
        int cnt=0;
        for (int i=0;i<egg;i++) {
            if (eggInfo[i][0]<=0) cnt ++;
        }
        return cnt;
    }

}
