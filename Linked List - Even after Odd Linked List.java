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
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    
    public static Node makeList(){
        Node head = null;
        Node tail = null;
        int t = sc.nextInt();
        while(t!=-1){
            if(head == null){
                head = new Node(t);
                tail = head;
            }else{
                Node node = new Node(t);
                tail.next = node;
                tail = tail.next;
            }
            t = sc.nextInt();
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = makeList();
        Node ptr = head;
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;
        
        while(ptr!= null){
            if(ptr.data % 2 == 0){
                if(evenHead == null){
                    evenHead = new Node(ptr.data);
                    evenTail = evenHead;
                }else{
                    evenTail.next = ptr;
                    evenTail = evenTail.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = new Node(ptr.data);
                    oddTail = oddHead;
                }else{
                    oddTail.next = ptr;
                    oddTail = oddTail.next;
                }
            }
            ptr = ptr.next;
        }
        if(oddTail != null){
            if(evenTail != null){
                oddTail.next = evenHead;
                evenTail.next = null;
            }else{
                oddTail.next = null;
            }
        }

       
        if(oddHead != null){
            printList(oddHead);
        }else{
            printList(evenHead);
        }
        
    }
}
