import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nEdges = sc.nextInt();
        
        int[] dist = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        
        int[][] edges = new int[nEdges][3];
        
        for(int i = 0; i<nEdges; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j<nEdges; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        Boolean negEdge = false;
        for(int j = 0; j<nEdges; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                negEdge = true;
            }
        }
        
        if(negEdge){
            System.out.println(-1);
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print(-1 + " ");
            }else{
                System.out.print(dist[i] + " ");
            }
        }
        
    }
}
