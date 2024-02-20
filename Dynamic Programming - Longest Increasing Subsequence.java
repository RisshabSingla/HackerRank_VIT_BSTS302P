import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = 1;
            arr[i] = sc.nextInt();
        }
        int maxi = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j] && dp[j] + 1 >= dp[i]){
                    dp[i] = dp[j] + 1;
                    maxi = Math.max(dp[i], maxi);
                }
            }
        }
        System.out.println(maxi);
    }
}
