import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        int vert_sum[] = new int[n];
        int hort_sum[] = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<n; j++){
                arr[i][j] = sc.nextInt();
                vert_sum[i] += arr[i][j];
                hort_sum[j] += arr[i][j];
            }
        }
        int index = -1;
        for(int i = 0; i<n; i++){
            if(vert_sum[i] == 0 && hort_sum[i] == n-1){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("No Celebrity");
        }else{
            System.out.println(index);
        }
    }
}
