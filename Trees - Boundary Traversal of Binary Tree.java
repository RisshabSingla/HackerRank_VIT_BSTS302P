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
    
    public static void addLeftBoundary(TreeNode head, ArrayList<Integer> ans){
        TreeNode curr = head.left;
        while(curr != null){
            if(curr.left == null && curr.right == null){
                return;
            }
            ans.add(curr.val);
            if(curr.left == null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
    }
    
    
    public static void addRightBoundary(TreeNode head, ArrayList<Integer> ans){
        TreeNode curr = head.right;
        ArrayList<Integer> arr = new ArrayList<>();
        while(curr != null){
            if(curr.left == null && curr.right == null){
                break;
            }
            arr.add(curr.val);
            if(curr.right == null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        
        for(int i = arr.size()-1; i>=0; i--){
            ans.add(arr.get(i));
        }
    }
    
    public static void addLeafNodes(TreeNode head, ArrayList<Integer> ans){
        if(head == null){
            return;
        }
        
        if(head.left == null && head.right == null){
            ans.add(head.val);
            return;
        }
        addLeafNodes(head.left, ans);
        addLeafNodes(head.right, ans);
    }
     
    public static void main(String[] args) {
        String str = sc.nextLine();
        String[] input = str.split(" ");
        int n = input.length;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        if(n == 0){
            return;
        }
        
        if(n == 1){
            System.out.print(arr[0]);
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
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(head.val);
        addLeftBoundary(head, ans);
        addLeafNodes(head, ans);
        addRightBoundary(head, ans);
        
        for(Integer i: ans){
            System.out.print(i + " ");
        }
        
    }
}
