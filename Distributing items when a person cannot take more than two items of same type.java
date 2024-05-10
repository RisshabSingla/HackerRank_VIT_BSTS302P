import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = input.length;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(!freq.containsKey(arr[i])){
                freq.put(arr[i], 0);
            }
            freq.put(arr[i], freq.get(arr[i])+1);
        }
        
        Boolean ans = true;
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() > 4){
                ans = false;
            }
        }
        if(ans == true){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
    }
}
