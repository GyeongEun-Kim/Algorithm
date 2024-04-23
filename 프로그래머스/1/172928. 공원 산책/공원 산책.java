import java.util.*;
import java.awt.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];
        Point point = new Point(0,0);
        
        for (int i=0;i<park.length;i++) {
            for (int j=0;j<park[i].length();j++) {
                map[i][j] = String.valueOf(park[i].charAt(j));
                if (map[i][j].equals("S")) point= new Point(j,i);
            }
        }
        
        for (int i=0;i<routes.length;i++) {
            String[] go =routes[i].split(" ");
            
            String direction = go[0];
            int far = Integer.parseInt(go[1]);
            int nx = point.x;
            int ny = point.y;
            boolean notMove = false;
            
            if (direction.equals("N")) { //북
                for (int k=1;k<=far;k++) {
                    ny+= (-1);
                    if (nx<0 || ny<0 || nx>=map[0].length || ny>= map.length) {
                        notMove = true;
                        break;
                    }
                    else if (nx>=0 && ny>=0 && nx<map[0].length && ny< map.length) {
                        if (map[ny][nx].equals("X")) {
                        notMove = true;
                        break;
                    }
                }
            }
            }
            else if (direction.equals("S")) { //남
                for (int k=1;k<=far;k++) {
                    ny+= 1;
                    if (nx<0 || ny<0 || nx>=map[0].length || ny>= map.length) {
                        notMove = true;
                        break;
                    }
                    else if (nx>=0 && ny>=0 && nx<map[0].length && ny< map.length) {
                        if (map[ny][nx].equals("X")) {
                        notMove = true;
                        break;
                    }
                 }
            }
            }
            else if (direction.equals("W")) { //서
                for (int k=1;k<=far;k++) {
                    nx+= (-1);
                    if (nx<0 || ny<0 || nx>=map[0].length || ny>= map.length) {
                        notMove = true;
                        break;
                    }
                    else if (nx>=0 && ny>=0 && nx<map[0].length && ny< map.length) {
                        if (map[ny][nx].equals("X")) {
                        notMove = true;
                        break;
                    }
                }
            }
            }
            else if (direction.equals("E")) { //동
                System.out.println("x:"+map[0].length);
                System.out.println("y:"+map.length);
                for (int k=1;k<=far;k++) {
                    nx+= 1;
                    if (nx<0 || ny<0 || nx>=map[0].length || ny>= map.length) {
                        notMove = true;
                        break;
                    }
                    else if (nx>=0 && ny>=0 && nx<map[0].length && ny< map.length) {
                        if (map[ny][nx].equals("X")) {
                        notMove = true;
                        break;
                    }
                }
            }
                System.out.println(notMove);
            }
            
            if (notMove == false) {
                point = new Point(nx, ny);
            }
            
            System.out.println(point);
        }
        
        answer[0] = point.y;
        answer[1] = point.x;
        
        return answer;
    }
}