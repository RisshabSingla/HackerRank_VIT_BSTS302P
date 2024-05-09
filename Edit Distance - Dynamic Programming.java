import java.io.*;
import java.util.*;

public class Solution {
    public static int findAnsRecursive(String str1, String str2, int index1, int index2, int n, int m){
        if(index1 == n && index2 == m){
            return 0;
        }
        if(index1 == n){
            return m-index2;
        }
        
        if(index2 == m){
            return n-index1;
        }
        
        if(str1.charAt(index1) == str2.charAt(index2)){
            return findAnsRecursive(str1, str2, index1+1, index2+1, n, m);
        }
        
        int a = findAnsRecursive(str1, str2, index1,index2+1, n, m); // insert
        int b = findAnsRecursive(str1, str2, index1+1,index2, n, m); // remove 
        int c = findAnsRecursive(str1, str2, index1+1,index2+1, n, m); // replace
        return Math.min(a, Math.min(b,c)) + 1;
    }
    
    public static int findAnsDP(String str1, String str2, int index1, int index2, int n, int m, int[][]dp){
        if(index1 == n && index2 == m){
            return 0;
        }
        if(index1 == n){
            return m-index2;
        }
        
        if(index2 == m){
            return n-index1;
        }
        
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        
        if(str1.charAt(index1) == str2.charAt(index2)){
            return dp[index1][index2] = findAnsDP(str1, str2, index1+1, index2+1, n, m, dp);
        }
        
        int a = findAnsDP(str1, str2, index1,index2+1, n, m, dp);
        int b = findAnsDP(str1, str2, index1+1,index2, n, m,dp); 
        int c = findAnsDP(str1, str2, index1+1,index2+1, n, m,dp); 
        return dp[index1][index2] = Math.min(a, Math.min(b,c)) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        // int ans = findAnsRecursive(str1, str2,0,0, str1.length(),str2.length());
        
        int n = str1.length();
        int m = str2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i<=n;i++){
            for(int j = 0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        int ans = findAnsDP(str1, str2, 0,0, n,m , dp);
        System.out.println(ans);
    }
}
