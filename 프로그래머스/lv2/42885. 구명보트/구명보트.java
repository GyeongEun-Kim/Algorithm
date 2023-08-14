import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i=0; //최소 무게 인덱스
        int j=people.length-1; //최대 무게 인덱스
        while (i<=j) {
            if(people[i]+people[j]<= limit) {
                i++; //가벼운 사람도 탐
                }
            answer++;
            j--; //무거운 사람은 무조건 탐
        }
        return answer;
    }
}