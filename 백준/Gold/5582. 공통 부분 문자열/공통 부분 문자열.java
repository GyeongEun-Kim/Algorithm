import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        /**
         * 투포인터로 비교?
         * 공통문자열이 잇으면 end+1하여 다시 비교
         */
        int start = 0;
        int end = 0;
        int longest =0;

        while (start<=end && end <=str1.length()) {
           // System.out.println("==========");
            //System.out.println("start : "+start+ "end : "+end);
            //System.out.println("longest: "+longest);
            String substring = str1.substring(start,end);
            int len = substring.length();
            boolean flag = false;
            for (int j=0;j<=str2.length()-len;j++) {
                if (substring.equals(str2.substring(j, j + len))) {
                    //공통문자열인 경우
                    //System.out.println("substr : "+substring);
                    longest = Math.max(longest,len);
                    end++;
                    flag=true;
                    break;
                }
            }
            if (flag==false) start++;
        }

        System.out.println(longest);

    }
}
