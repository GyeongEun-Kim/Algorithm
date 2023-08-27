import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        String answer = "";
        int[][] map = new int[n+1][n+1];
        int x = 1;
        int y =1; //시작 좌표
        int num = n*n;
        map[y][x] = num;

        //바깥부터 안으로
        while (num>0) {
            if (num==1) break;
            while (y+1<=n && map[y+1][x]==0 ) map[++y][x] = --num;
            while (x+1<=n && map[y][x+1]==0 ) map[y][++x] = --num;
            while (y-1>=1 && map[y-1][x]==0 ) map[--y][x] = --num;
            while (x-1>=1 && map[y][x-1]==0 ) map[y][--x] = --num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                sb.append(map[i][j]+" ");
                if (map[i][j]==target) answer = i+" "+j;
            }
            if (i!=n) sb.append("\n");
        }

        System.out.println(sb.toString());
        System.out.println(answer);

    }
}