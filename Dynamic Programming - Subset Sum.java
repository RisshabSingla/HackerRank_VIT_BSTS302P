import java.io.*;
import java.util.*;

public class Solution {
    public static Boolean findAnsRecursive(int[] arr, int target, int index, int n){
        if(index == n){
            if(target == 0){
                return true;
            }
            return false;
        }
        
        return findAnsRecursive(arr, target-arr[index], index+1, n) || findAnsRecursive(arr, target, index+1, n);
    }
    
    public static int findAnsDP(int[] arr, int target, int index, int n, int[][]dp){
        if(target < 0){
            return 0;
        }
        
        if(index == n){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int a = findAnsDP(arr, target-arr[index], index+1, n, dp);
        int b = findAnsDP(arr, target, index+1, n, dp);
        if(a == 1 || b == 1){
            dp[index][target] = 1;
        }else{
            dp[index][target] = 0;
        }
        return dp[index][target];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        // Boolean possible = findAnsRecursive(arr, target, 0, n);
        
        int[][] dp = new int[n+1][target+1];
        for(int i = 0; i<=n;i++){
            for(int j = 0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        int ans = findAnsDP(arr, target,0,n, dp);
        if(ans == 1){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
