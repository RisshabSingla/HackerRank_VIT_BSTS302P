import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a,b) -> a.get(1) - b.get(1));
        int n = sc.nextInt();
        while(n != 4){
            if(n == 1){
                // insertion
                int data = sc.nextInt();
                int priority = sc.nextInt();
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(data);
                arr.add(priority);
                pq.add(arr);
            }else if(n == 2){
                // deletion
                if(pq.isEmpty()){
                    System.out.println("Error List Empty");
                }else{
                    pq.poll();
                }
                
            }else if(n == 3){
                // display
                if(pq.isEmpty()){
                    System.out.println("Empty");
                }else{
                    System.out.print("Queue: ");
                    for(ArrayList<Integer> p : pq){
                        for(int a : p){
                            System.out.print(a + " ");
                        }
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Wrong Choice");
            }
            n = sc.nextInt();
        }
    }
}
