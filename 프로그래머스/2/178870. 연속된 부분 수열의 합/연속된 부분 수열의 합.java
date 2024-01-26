class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum =0;
        int len = Integer.MAX_VALUE;
        
        while (true) {
        
            if (sum >= k) {
                sum = sum -sequence[start];
                start++;
            }
            else if (end >= sequence.length) break;
            else if (sum< k) {
                sum= sum + sequence[end];
                end ++;
            }
            
            
            if (sum ==k) {
                if (end - start < len) {
                    answer[0] = start;
                    answer[1] = end -1; //왜 -1을 하는지
                    len = end-start;
                }
            }
        }
        return answer;
    }
}