import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    
    public static void performBFS( ArrayList<ArrayList<Integer>> adj_list, int vertices){
        boolean visited[] = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            visited[i] = false;
        }
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        System.out.print("BFS : ");
        while(!queue.isEmpty()){
            int front = queue.remove();
            System.out.print(front+ " ");
            for(int i = 0; i<adj_list.get(front).size(); i++){
                int node = adj_list.get(front).get(i);
                if(visited[node] == false){
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int vertices = sc.nextInt();
        if(vertices == 0){
            System.out.println("Graph doesn't exist");
            return ;
        }
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<vertices; i++){
            adj_list.add(new ArrayList<Integer>());
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(a != -1){
            adj_list.get(a).add(b);
            // adj_list.get(b).add(a);
            a = sc.nextInt();
            b = sc.nextInt();
        }
        
        // for(int i = 0; i<adj_list.size(); i++){
        //     System.out.print(i + " : ");
        //     for(int j = 0; j<adj_list.get(i).size(); j++){
        //         System.out.print(adj_list.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
      
        performBFS(adj_list, vertices);
        
    }
}
