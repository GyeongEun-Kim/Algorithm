import java.util.*;
class Solution {
    int root[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        //kruskal algorithm : 무방향 가중치 그래프에서 모든 정점을 연결하는 최소비용을 구하는 알고리즘 (union-find 활용)
        //간선 중심으로 최소비용을 구함
        root = new int[n];
        
        Arrays.sort(costs, (o1,o2) -> {
            return o1[2]-o2[2];
        });
        //간선 가중치를 오름차순 정렬
        System.out.println(Arrays.deepToString(costs));
        
        for (int i=0;i<n;i++) {
            root[i] = i; //union-find를 위한 초기화
        }
        
        for (int i=0;i<costs.length;i++) {
            int na= costs[i][0];
            int nb= costs[i][1];
            int cost = costs[i][2];
            
            if(find(na)!= find(nb)) {
                answer+=cost;
                root[find(nb)] = find(na);
                
            }
        } 

        
        return answer;
    }
    public void union(int x , int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) 
            root[y] = rootX;
    
    }
    
    public int find(int x) {
        if (root[x]==x) return x;
        else {
            root[x] = find(root[x]);
            return root[x];
         }
    }
}