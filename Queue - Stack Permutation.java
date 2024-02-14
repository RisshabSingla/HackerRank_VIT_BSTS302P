import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str_arr1[] = str1.split(" ");
        String str_arr2[] = str2.split(" ");
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        for(String str: str_arr1){
            arr1.add(Integer.parseInt(str));
        }
        
        for(String str: str_arr2){
            arr2.add(Integer.parseInt(str));
        }
        
        Stack<Integer> stk = new Stack<>();
        
        int index = 0;
        int n = arr1.size();
        for(int i = 0; i<n; i++){
            if(stk.isEmpty() || stk.peek() != arr2.get(index)){
                stk.push(arr1.get(i));
            }
            while(!stk.isEmpty() && stk.peek() == arr2.get(index)){
                index++;
                stk.pop();
            }
        }
        
        while(index != n){
            if(stk.peek() != arr2.get(index)){
                break;
            }
            index++;
            stk.pop();
        }
        
        if(index == n){
            System.out.println("YES");
        }else{
            System.out.println("Not Possible");
        }
    }
}
