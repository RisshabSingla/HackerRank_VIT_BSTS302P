import java.io.*;
import java.util.*;

public class Solution {
    static int findAnsDP(String str1, String str2, int index1, int index2, int n, int m , int[][]dp){
        if(index1 == n || index2 == m){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(str1.charAt(index1) == str2.charAt(index2)){
            return findAnsDP(str1, str2, index1+1, index2+1, n, m, dp) + 1;
        }
        int a = findAnsDP(str1,str2, index1+1, index2, n,m,dp);
        int b = findAnsDP(str1,str2, index1, index2+1, n,m,dp);
        dp[index1][index2] = Math.max(a,b); 
        return dp[index1][index2];
    }
    
    static int longestCommon(String str){
        int n = str.length();
        int m = str.length();
        String str1 = str;
        String str2 = new StringBuilder(str).reverse().toString();
        int [][] arr = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j=0; j<=m; j++){
                arr[i][j] = -1;
            }
        }
        int ans = findAnsDP(str1, str2, 0,0, n,m , arr);
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestCommon(str));
    }
}
