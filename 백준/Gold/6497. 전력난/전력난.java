import java.io.BufferedReader;                                                                                        
import java.io.IOException;                                                                                           
import java.io.InputStreamReader;                                                                                     
import java.util.Arrays;                                                                                              
import java.util.Collections;                                                                                         
                                                                                                                      
public class Main {                                                                                             
    static int[] root;                                                                                                
    static int[][] data;                                                                                              
    static int cost;                                                                                                  
    static int count;                                                                                                 
    public static void main(String[] args) throws IOException {                                                       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                     
                                                                                                                      
        while (true) {                                                                                                
            String input = br.readLine();                                                                             
            if (input.equals("0 0")) break;                                                                           
            String[] nums = input.split(" ");                                                                         
            int m = Integer.parseInt(nums[0]); //집의수                                                                  
            int n = Integer.parseInt(nums[1]); //길의수                                                                  
            data = new int[n][3];                                                                                     
            root = new int[m];                                                                                        
            cost =0;                                                                                                  
            count =0;                                                                                                 
                                                                                                                      
            int result=0;                                                                                             
                                                                                                                      
            for (int i=0;i<m;i++) root[i] = i; //union-find 초기화                                                       
                                                                                                                      
            for (int i = 0; i < n; i++) {                                                                             
                String houses[] = br.readLine().split(" ");                                                           
                data[i][0] = Integer.parseInt(houses[0]);                                                             
                data[i][1] = Integer.parseInt(houses[1]);                                                             
                data[i][2] = Integer.parseInt(houses[2]);                                                             
                result += data[i][2];                                                                                 
            }                                                                                                         
                                                                                                                      
            Arrays.sort(data,(o1,o2)->  o1[2] - o2[2]); //가중치 오름차순으로 정리 - 크루스칼                                        
                                                                                                                      
            for (int i=0;i<n;i++) {                                                                                   
                if (count == m-1) break;                                                                              
                union(data[i][0], data[i][1], data[i][2]);                                                            
            }                                                                                                         
                                                                                                                      
            //System.out.println(result);                                                                             
            //System.out.println(cost);                                                                               
            System.out.println(result-cost);                                                                          
                                                                                                                      
        }                                                                                                             
    }                                                                                                                 
                                                                                                                      
    public static void union (int x, int y, int m) {                                                                  
        int rx = find(x);                                                                                             
        int ry = find(y);                                                                                             
                                                                                                                      
        if (rx!=ry) {                                                                                                 
            //root[y] = rx;                                                                                           
            root[rx] = y;                                                                                             
            // else if (rx>ry) root[x] = ry;                                                                          
            cost += m;                                                                                                
            count++;                                                                                                  
        }                                                                                                             
                                                                                                                      
    }                                                                                                                 
                                                                                                                      
    public static int find(int x) {                                                                                   
        if(root[x]==x) return x;                                                                                      
        root[x] = find(root[x]);                                                                                      
        return root[x];                                                                                               
    }                                                                                                                 
}                                                                                                                     
                                                                                                                      