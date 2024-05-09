import java.io.*;
import java.util.*;

public class Solution {
    public static Boolean findAnsRecursive(String str1, String str2, int index1, int index2, int n, int m){
        if(index1 == n && index2 == m){
            return true;
        }
        if(index1 >= n || index2 >= m){
            return false;
        }
        if(str2.charAt(index2) == '*'){
            return findAnsRecursive(str1, str2, index1+1, index2, n,m) || findAnsRecursive(str1, str2, index1, index2+1, n,m);
        }
        
        if(str2.charAt(index2) == '?'){
            return findAnsRecursive(str1, str2, index1+1, index2+1, n,m);
        }
        
        if(str1.charAt(index1) == str2.charAt(index2)){
            return findAnsRecursive(str1, str2, index1+1, index2+1, n,m);
        }
        return false;
    }
    
    public static int findAnsDP(String str1, String str2, int index1, int index2, int n, int m, int[][]dp){
        if(index1 == n && index2 == m){
            return 1;
        }
        if(index1 >= n || index2 >= m){
            return 0;
        }
        
        if(dp[index1][index2] != -1){
            return  dp[index1][index2];
        }
        
        if(str2.charAt(index2) == '*'){
            int a = findAnsDP(str1, str2, index1+1, index2, n,m,dp);
            int b = findAnsDP(str1, str2, index1, index2+1, n,m,dp);
            if(a == 1 || b == 1){
                return dp[index1][index2] = 1;
            }
            return dp[index1][index2] = 0;
        }
        
        if(str2.charAt(index2) == '?' ){
            return dp[index1][index2] =  findAnsDP(str1, str2, index1+1, index2+1, n,m,dp);
        }
        
        if(str1.charAt(index1) == str2.charAt(index2)){
            return dp[index1][index2] = findAnsDP(str1, str2, index1+1, index2+1, n,m,dp);
        }
        return dp[index1][index2] =  0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
//         Boolean possible = findAnsRecursive(str1, str2, 0,0,str1.length(), str2.length());
//         if(possible){
//             System.out.println("true");
//         }else{
//             System.out.println("false");
//         }
        
        int n = str1.length();
        int m = str2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j= 0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        
        int possible = findAnsDP(str1, str2, 0,0,n,m, dp);
        if(possible == 1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        
        
    }
}
