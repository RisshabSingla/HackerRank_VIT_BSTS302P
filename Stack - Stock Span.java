import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stk = new Stack<Integer>();
        System.out.print("1 ");
        stk.push(0);
        for(int i = 1; i<n; i++){
            while(!stk.empty() && arr[stk.peek()] <= arr[i]){
                stk.pop();
            }
            if(stk.empty()){
                System.out.print((i+1) + " ");
            }else{
                System.out.print((i - stk.peek()) + " ");
            }
            stk.push(i);
        }
    }
}
