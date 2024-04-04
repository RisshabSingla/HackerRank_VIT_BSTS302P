import java.io.*;
import java.util.*;

public class Solution {
   static Scanner sc = new Scanner(System.in);
    static class TreeNode{
        int val;
        int index;
        TreeNode left;
        TreeNode right;
        
        TreeNode(){
            val = -1;
            index = -1;
            left = null;
            right = null;
        }
        TreeNode(int val){
            index = -1;
            this.val = val;
            left = null;
            right = null;
        }
    }
    
    
    public static void findIndexes(TreeNode head, int value){
        if(head == null){
            return;
        }
        head.index = value;
        findIndexes(head.left, value-1);
        findIndexes(head.right, value+1);
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
        
        findIndexes(head, 0);
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        
        q.clear();
        q.add(head);
        q.add(null);
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode front = q.remove();
            if(front == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                continue;
            }
            if(mp.get(front.index) == null){
                mp.put(front.index, new ArrayList<Integer>());
            }
            mini = Math.min(mini, front.index);
            maxi = Math.max(maxi, front.index);
            mp.get(front.index).add(front.val);
            if(front.left != null){
                q.add(front.left);
            }
            if(front.right != null){
                q.add(front.right);
            }
        }
      
        for(int i = mini;i<=maxi; i++){
            ArrayList<Integer> elem = mp.get(i);
            for(Integer e : elem){
                System.out.print(e + " ");
            }
        }
        
    }
}
