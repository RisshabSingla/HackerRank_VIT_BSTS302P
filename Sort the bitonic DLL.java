import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static class Node{    
        int data;    
        Node next;   
        Node prev;

        public Node(int data) {    
            this.data = data;    
            this.next = null;   
            this.prev = null;
        }      
    }
    public static void printList(Node ptr){
        while(ptr != null){
            System.out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
    
    public static Node makeList(){
        Node head = null;
        Node tail = null;
        int t = sc.nextInt();
        
        while(t!= -1){
            if(head == null){
                head = new Node(t);
                tail = head;
            }else{
                Node node = new Node(t);
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
            t = sc.nextInt();
        }
        return head;
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int t = sc.nextInt();
            while(t != -1){
                arr.add(t);
                t = sc.nextInt();
            }
            Collections.sort(arr);
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            
        }
    }
}
