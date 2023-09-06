import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //9:38
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int plate = Integer.parseInt(input[0]); //벨트위에 놓인 접시 갯수
        int sushi = Integer.parseInt(input[1]); //초밥 가지수
        int cont = Integer.parseInt(input[2]); //연속해서 먹는 초밥 갯수
        int coupon = Integer.parseInt(input[3]); //쿠폰 번호

        int[] belt = new int[plate];
        for (int i=0;i<plate;i++) {
            belt[i]= Integer.parseInt(br.readLine());
        }//input

        int answer =0;

        for (int i=0;i<plate;i++) {
            Set<Integer> set = new HashSet<>();
            set.add(coupon);
            for (int j=0;j<cont;j++) {
                if (i+j<plate) set.add(belt[i+j]);
                else {
                    set.add(belt[i+j-plate]);
                }
            }
//
//            Iterator iter = set.iterator();
//            while(iter.hasNext()) {
//                System.out.print(iter.next()+" ");
//            }
//            System.out.println();


            if (answer< set.size()) answer= set.size();

        }
        System.out.println(answer);
    }
}