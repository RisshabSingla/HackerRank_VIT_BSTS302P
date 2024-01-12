import java.io.*;
import java.util.*;

public class Solution {
    static class Node{    
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
        public void printList(Node ptr){
            while(ptr != null){
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }
        }
    }    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println("Failed to read middle element");
            return;
        }
        Node head = null;
        Node tail = null;
        for(int i = 0; i<n; i++){
            int t = sc.nextInt();
            if(head == null){
                head = new Node(t);
                tail = head;
            }else{
                Node node = new Node(t);
                tail.next = node;
                tail = tail.next;
            }
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
}
