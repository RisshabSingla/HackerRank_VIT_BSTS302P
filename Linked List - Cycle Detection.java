import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean duplicate = false;
        Set<Integer> present = new HashSet<Integer>();
        for(int i = 0; i<n; i++){
            int t = sc.nextInt();
            if(present.contains(t)){
                duplicate = true;
            }
            present.add(t);
        }
        if(duplicate){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
