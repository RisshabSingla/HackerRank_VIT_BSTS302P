import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i<n;i++){
            coins[i] = sc.nextInt();
        }
        
        int val = sc.nextInt();
        long[] ways = new long[val+2];
        ways[0] = 0;
        for(int i = 1; i<=val; i++){
            ways[i] = Integer.MAX_VALUE;
            for(int coin: coins){
                if(i-coin>=0){
                    ways[i] = Math.min(ways[i], ways[i-coin] + 1);
                }
            }
        }
        System.out.print(ways[val]);
    }
}
