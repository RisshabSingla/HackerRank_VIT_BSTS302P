import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner sc = new Scanner(System.in);
    
    static int[] findLIS(int[] arr, int n){
        int[] lis = new int[n];
        for(int i = 0; i<n; i++){
            lis[i] = 1;
        }
        for(int i = 1;i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }
        return lis;
    }
    
     static int[] findLDS(int[] arr, int n){
        int[] lds = new int[n];
        for(int i = 0; i<n; i++){
            lds[i] = 1;
        }
        for(int i = n-2;i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(arr[i] > arr[j] && lds[i] < lds[j]+1){
                    lds[i] = lds[j]+1;
                }
            }
        }
        return lds;
    }
    
    static int findAns(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int[] lis = findLIS(arr, n);
        int[] lds = findLDS(arr, n);
        int ans = 0;
        for(int i = 0; i<n; i++){
            int a = lis[i] + lds[i]-1;
            ans = Math.max(a, ans);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            int ans = findAns();
            System.out.println(ans);
        }
    }
}
