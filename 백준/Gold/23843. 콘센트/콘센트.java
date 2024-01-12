import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); //전자 기기 갯수
        int m = Integer.parseInt(str[1]); //콘센트 갯수
        String[] input = br.readLine().split(" ");
        int result = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);

       for (int i=0;i<n;i++) {
           //System.out.println(input[i]);
           left.add(Integer.parseInt(input[i]));
       }
        //System.out.println("peek = " + left.peek());

       PriorityQueue<Integer> outlet = new PriorityQueue<>( );

       if (n <= m ) {
           result= left.poll();
       }
       else {
           while (!left.isEmpty()) {
               for (int i = 0; i < m; i++) {
                   //System.out.println("outlet.size() = " + outlet.size());
                   if(left.isEmpty()) break;
                   Integer poll = left.poll();
                   if (outlet.size() < m) outlet.add(poll);
                   else outlet.add(outlet.poll()+poll);
               }
           }


           //pq에서 가장 뒤에 값 찾기
           int size = outlet.size()-1;
           for (int i=0;i<size;i++) {
               outlet.poll();
           }
           result = outlet.poll();
       }

        System.out.println(result);

        /**
         * 8 4 4 1 1
         *
         * 5 5 8
         */
    }
}
