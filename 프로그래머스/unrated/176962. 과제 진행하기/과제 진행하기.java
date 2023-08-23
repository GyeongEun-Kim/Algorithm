import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>(); //정답을 담는 리스트
        Stack<String[]> stack =new Stack<>(); //멈춰둔 과제를 담는 스택
        Arrays.sort(plans, (o1,o2) -> {
            return o1[1].compareTo(o2[1]);
        }); //과제 시작시간이 빠른순으로 정렬
        
        for (int i=0;i<plans.length-1;i++) {
            int leftTime = getLeftTime(plans[i][1],plans[i+1][1]);
            //현재 시작하는 과제와 그다음 과제의 시작시간의 차이
            if ( leftTime >= Integer.parseInt(plans[i][2])) {
                //1. 과제소요 시간보다 시간이 남는 경우
                answer.add(plans[i][0]);
                //1-1. 과제 다 끝냄  
                leftTime-=Integer.parseInt(plans[i][2]);
               
                //1-2. 멈춰둔 과제가 있다면, 남는 시간동안 멈춰둔걸 하기
                while (leftTime>0 && !stack.isEmpty()) {
                    String[] cur = stack.pop();
                    int curPlayTime = Integer.parseInt(cur[2]);
                    if (leftTime- curPlayTime >=0) {
                        //현재 과제를 다할 수 있는경우
                        answer.add(cur[0]);
                        leftTime-=curPlayTime;
                        
                    }
                    else {
                        //현재 과제를 다하기에 시간 부족한 경우
                        cur[2]= String.valueOf(curPlayTime-leftTime);
                        stack.push(cur);
                        leftTime =0;
                    }
                }
                
            }
            else { //2. 과제 소요시간 보다 시간이 부족해서 중간에 멈춰야하는 경우
                plans[i][2]= String.valueOf(Integer.parseInt(plans[i][2])-leftTime);
                stack.push(plans[i]);
            }
        }
        
        answer.add(plans[plans.length-1][0]); //마지막 과제는 시간 상관없이 무조건 끝내므로 answer에 더해줌
    
        //멈춰둔 과제를 모두 진행
        while (!stack.isEmpty()) {
            String[] cur = stack.pop();
            answer.add(cur[0]);
        }
            
        return answer.toArray(new String[answer.size()]);
    }
    
    
    public int getLeftTime(String startTime, String endTime) {
        int startHour = Integer.parseInt(startTime.split(":")[0]); //12
        int startMin = Integer.parseInt(startTime.split(":")[1]); //40
        int endHour = Integer.parseInt(endTime.split(":")[0]); //14
        int endMin = Integer.parseInt(endTime.split(":")[1]); //00
        
        return (endHour*60 + endMin)- (startHour*60+startMin);
        
    }
    

}