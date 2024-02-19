import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static boolean visited[];
    public static void performDFS( ArrayList<ArrayList<Integer>> adj_list, int start){
        int size = adj_list.get(start).size();
        System.out.print(start + " ");
        for(int i = 0; i<size;i++){
            int node = adj_list.get(start).get(i);
            if(visited[node] == false){
                visited[node] = true;
                performDFS(adj_list, node);
            }
        }
    }
  
    public static void main(String[] args) {
        int vertices = sc.nextInt();
        visited = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            visited[i] = false;
        }
        if(vertices == 0){
            System.out.println("Graph doesn't exist");
            return ;
        }
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<vertices; i++){
            adj_list.add(new ArrayList<Integer>());
        }
        int edges = sc.nextInt();
        for(int i = 0; i<edges; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj_list.get(a).add(b);
            adj_list.get(b).add(a);
        }
        
        visited[0] = true;
        performDFS(adj_list, 0);
        
    }
}
