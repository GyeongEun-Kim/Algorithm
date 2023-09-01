import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class Main{
    static int visited[];
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]); //수빈이의 위치
        M = Integer.parseInt(temp[1]); //동생의 위치

        visited= new int[max(N,M)+10];
        bfs(N);
        System.out.println(visited[M]-1);
    }

    static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        visited[N]=1;
        queue.add(N);
        while (!queue.isEmpty()) {
            //System.out.println(queue.peek());
            int current = queue.poll();
            int left = current-1;
            int right = current+1;
            int twice = 2*current;

            if (left>=0 && visited[left]==0) {
                visited[left] = visited[current] + 1;
                queue.add(left);

            }
            if (right< visited.length && visited[right]==0) {
                visited[right] = visited[current] + 1;
                queue.add(right);
                //System.out.println("current= "+current+" 횟수는= "+visited[right]);
            }
            if (twice < visited.length && visited[twice]==0) {
                visited[twice] = visited[current] + 1;
                queue.add(twice);
            }
        }
    }
}
