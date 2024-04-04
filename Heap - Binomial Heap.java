import java.io.*;
import java.util.*;

public class Solution {
    
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
    
    public static void main(String[] args) {
        
        String str = sc.nextLine();
        String[] input = str.split(" ");
        int n = input.length;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            if(input[i].equals("null")){
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
        
        q.add(head);
        q.add(null);
        int prev = head.val;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode front = q.remove();
            if(front == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                ans.add(prev);
                continue;
            }
            prev = front.val;
            if(front.left != null){
                q.add(front.left);
            }
            if(front.right != null){
                q.add(front.right);
            }
        }
        
        for(Integer i: ans){
            System.out.print(i+ " ");
        }
    
    }
}
