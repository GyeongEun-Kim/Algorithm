import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]); //기차의 수
        int M = Integer.parseInt(str[1]); //명령의 수
        int cnt =0 ;//은하수를 건널수있는 기차의 수

        List<int[]> trains = new ArrayList<>();
        for (int j=0;j<=100000;j++) {
            trains.add(new int[21]);
        }

        for (int j=0;j<M;j++) {
            String command[] = br.readLine().split(" ");

            String num = command[0];
            int i = Integer.parseInt(command[1]);

            if (num.equals("1")) { //i번쨰 기차의 x칸에 사람 태우기
                int x = Integer.parseInt(command[2]);

                if (trains.get(i)[x] ==0) { //비어있으면

                    trains.get(i)[x] = 1;
                }
            }
            else if (num.equals("2")) { //i번쨰 기차의 x칸에 사람 하차시키기
                int x = Integer.parseInt(command[2]);
                if (trains.get(i)[x] != 0) { //타있으면
                    trains.get(i)[x] = 0;
                }
            }
            else if (num.equals("3")) {
                int[] train = trains.get(i);
                for (int k=20;k>=1;k--) {
                    train[k] = train[k-1];
                }
            }
            else {
                int[] train = trains.get(i);
                for (int k=1;k <=19;k++) {
                    train[k] = train[k+1];
                }
                train[20] = 0;
            }

        }
        //승객 이동 끝

        Set<String> set = new HashSet<>();
        //이제 은하수 건너기
        for (int i=1;i<=N;i++) {
            int[] train = trains.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j=1;j<=20;j++) {
                sb.append(train[j]);
            }
            //System.out.println(sb.toString());
            set.add(sb.toString());
        }

        System.out.println(set.size());

    }
}
