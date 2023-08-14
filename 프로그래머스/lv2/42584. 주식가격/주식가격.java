import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        for (int i=0;i<prices.length;i++) {
            int cnt=-1;
            for (int j=i;j<prices.length;j++) {
                if (prices[i]<= prices[j]) {
                    cnt++;
                }
                else {
                    cnt++;
                    break;
                }
            }
            result[i]= cnt;
        }
        
        return result;
    }
}