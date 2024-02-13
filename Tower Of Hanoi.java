import java.io.*;
import java.util.*;

public class Solution {
    static void towerOfHanoi(int n, String source, String aux, String dest){
        if(n == 0){
            return;
        }
        towerOfHanoi(n-1, source, dest, aux);
        System.out.println(source + " " + dest);
        towerOfHanoi(n-1, aux, source, dest);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towerOfHanoi(n, "a", "b", "c");
    }
}
