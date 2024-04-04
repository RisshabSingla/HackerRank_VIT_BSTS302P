import java.io.*;
import java.util.*;

public class Solution {
    static int index = 0;
    static TreeNode first;
    static TreeNode middle;
    static TreeNode last;
    static TreeNode prev;
    
    static Scanner sc = new Scanner(System.in);
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(){
            val = -1;
            left = null;
            right = null;
        }
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    
    public static void findInorder(TreeNode head){
        if(head == null){
            return ;
        }
        
        findInorder(head.left);
        
        if(prev != null && (head.val < prev.val)){
            if(first == null){
                first = prev;
                middle= head;
            }else{
                last = head;
            }
        }
        prev = head;
        findInorder(head.right);
    }
    
    
    public static void printDFS(TreeNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val + " ");
        printDFS(head.left);
        printDFS(head.right);
    }
    
    
    public static void main(String[] args) {
        String str = sc.nextLine();
        String[] input = str.split(" ");
        int n = input.length;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            if(input[i].equals("N")){
                arr[i] = -1;
                continue;
            }
            arr[i] = Integer.parseInt(input[i]);
        }
        
        if(n == 0){
            return;
        }
        
        
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        for(int i = 1; i<n; i+=2){
            TreeNode front = q.remove();
            if(arr[i] != -1){
                front.left = new TreeNode(arr[i]);
                q.add(front.left);
            }
            
            if(i+1 < n && arr[i+1] != -1){
                front.right = new TreeNode(arr[i+1]);
                q.add(front.right);
            }
        }
        
        q.clear();
        
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        findInorder(head);
        
        if(first != null && last!= null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
            
        }else if(first != null && middle!= null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
        
        printDFS(head); 
    }
}
