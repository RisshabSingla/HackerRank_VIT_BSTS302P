import java.io.*;
import java.util.*;

public class Solution {
    
    static int findAnsRecursive(String str1, String str2, int index1, int index2, int n, int m ){
        if(index1 == n || index2 == m){
            return 0;
        }
        if(str1.charAt(index1) == str2.charAt(index2)){
            return findAnsRecursive(str1, str2, index1+1, index2+1, n, m) + 1;
        }
        int a = findAnsRecursive(str1,str2, index1+1, index2, n,m);
        int b = findAnsRecursive(str1,str2, index1, index2+1, n,m);
        return Math.max(a,b); 
    }
    
    
    static int findAnsDP(String str1, String str2, int index1, int index2, int n, int m , int[][]dp){
        if(index1 == n || index2 == m){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(str1.charAt(index1) == str2.charAt(index2)){
            return findAnsRecursive(str1, str2, index1+1, index2+1, n, m) + 1;
        }
        int a = findAnsRecursive(str1,str2, index1+1, index2, n,m);
        int b = findAnsRecursive(str1,str2, index1, index2+1, n,m);
        dp[index1][index2] = Math.max(a,b); 
        return dp[index1][index2];
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int n = str1.length();
        int m = str2.length();
        // int ans = findAnsRecursive(str1, str2, 0,0, n,m);
        
        int [][] arr = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j=0; j<=m; j++){
                arr[i][j] = -1;
            }
        }
        
        int ans = findAnsDP(str1, str2, 0,0, n,m , arr);
        System.out.println(ans);
    }
}
