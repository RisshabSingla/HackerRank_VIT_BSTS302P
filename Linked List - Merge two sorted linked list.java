import java.io.*;
import java.util.*;


public class Solution {
    static Scanner sc = new Scanner(System.in);
    static class Node{    
        int data;    
        Node next;                

        public Node(int data) {    
            this.data = data;    
            this.next = null;    
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
    
    public static Node makeList(int n){
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
        return head;
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        Node head1 = makeList(n);
        int m = sc.nextInt();
        Node head2 = makeList(m);
        
        Node head = new Node(-1);
        if(head1.data > head2.data){
            head.data = head2.data;
            head2 = head2.next;
        }else{
            head.data = head1.data;
            head1 = head1.next;
        }
        Node tail = head;
        // tail.data = head.data;
        while(head1!= null && head2 != null){
            if(head1.data > head2.data){
                // if(head.next)
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }else{
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
        }
        while(head1!=null){
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        while(head2!=null){
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        tail.next = null;
        printList(head);
  
    }
}
