import java.util.*;
class Solution {
    int answer =0;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        
        visited= new boolean[words.length];
        backTrack(begin, target, words , 0);

        
        return answer;
    }
    
    public void backTrack (String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        for (int i=0;i<words.length;i++) {
            int fix =0;
            if (visited[i]==false) {
            for (int j=0;j<target.length();j++) {
                if (begin.charAt(j)!=words[i].charAt(j)) {
                    fix ++;
                    }
                }
        if (fix ==1) {
            visited[i] =true;
            backTrack(words[i], target, words, cnt+1);
            visited[i] = false;
        }
            }
        }
    }

}