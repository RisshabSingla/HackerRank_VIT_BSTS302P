import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num = sc.nextInt();
        for(int j = 0;j<num; j++){
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Stack<Integer> stk = new Stack<Integer>();
            for(int i = 0; i<n; i++){
                if(stk.empty() == true){
                    stk.push(arr[i]);   
                }else{
                    int top = stk.peek();
                    if(top > arr[i]){
                        stk.push(arr[i]);
                    }
                }
            }
            System.out.println(stk.peek());
        }
    }
}
