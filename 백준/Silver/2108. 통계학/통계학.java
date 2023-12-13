import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> count = new HashMap<>(); //key를 string으로 하는이유???
        int[] arr = new int[n];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            max = Math.max(max, num);
            min = Math.min(min, num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }


        //산술평균
        double divide = (double) sum / n;
        if (divide < 0) System.out.println(Math.round(divide) );
        else System.out.println(Math.round(divide));

        //중앙값
        Arrays.sort(arr);
        System.out.println(arr[n / 2]);

        //최빈값
        List<Integer> keySet = new ArrayList<>(count.keySet());
        keySet.sort(((o1, o2) -> {
            if (count.get(o2) - count.get(o1) > 0)
                return 1; //빈도수 내림차순 정렬
            else if (count.get(o2) - count.get(o1) == 0) //빈도수가 같다면?
                return o1-o2; //숫자는 오름차순 정렬
            else return -1;
        }));
//
//        for (int i=0;i<keySet.size();i++) {
//            String k = keySet.get(i);
//            System.out.println("key : "+k+" count : "+count.get(k));
//        }


        if (count.size() > 1 && count.get(keySet.get(0)) == count.get(keySet.get(1))) {
            System.out.println(keySet.get(1));
        } else System.out.println(keySet.get(0));

        //범위
        System.out.println(max - min);

    }
}