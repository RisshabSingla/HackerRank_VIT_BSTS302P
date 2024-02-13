import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for(int i = 0; i<k; i++){
            pq.add(new Pair<Integer,Integer>(i, arr[i]));
        }
        int front = 0;
        for(int i = k; i<n; i++){
            while(pq.peek().getKey() < front){
                // outside of interval
                pq.poll();
            }
            front++;
            System.out.print(pq.peek().getValue() + " ");
            pq.add(new Pair<Integer,Integer>(i, arr[i]));
        }
        System.out.println(pq.peek().getValue() + " ");
    }
}
