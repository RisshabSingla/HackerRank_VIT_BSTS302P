import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a,b) -> b.get(1) - a.get(1));
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for(int i = 0; i<k; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(arr[i]);
            pq.add(temp);
        }
        int front = 0;
        for(int i = k; i<n; i++){
            while(pq.peek().get(0) < front){
                // outside of interval
                pq.poll();
            }
            front++;
            System.out.print(pq.peek().get(1) + " ");
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(arr[i]);
            pq.add(temp);
        }
        System.out.println(pq.peek().get(1) + " ");
    }
}
