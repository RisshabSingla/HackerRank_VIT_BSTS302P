import java.io.*;
import java.util.*;
import javafx.util.*;


public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        int n = sc.nextInt();
        while(n != 4){
            if(n == 1){
                // insertion
                int data = sc.nextInt();
                int priority = sc.nextInt();
                pq.add(new Pair<Integer,Integer>(data, priority));
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
                    for(Pair<Integer,Integer> p : pq){
                        System.out.print(p.getKey() + " " + p.getValue() + " ");
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
