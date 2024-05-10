import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.substring(1, input.length()-1).trim();
        String[] inp = input.split(", ");
        TreeMap<String, String> tmap = new TreeMap<>();
        for(String str: inp){
            String[] s = str.split("->");
            s[0] = s[0].substring(1, s[0].length()-2);
            tmap.put(s[0], s[1].trim());
        }
        
        int size=tmap.entrySet().size();
        int count = 0;
        
        System.out.print("{ ");
        for(Map.Entry <String,String>entry: tmap.entrySet())
        {
            count++;
            if(count!=size)
            {
                System.out.print("\"" + entry.getKey()+ "\"" + " -> "+entry.getValue()+", ");
            }
            else
            {
                System.out.print("\"" + entry.getKey()+ "\"" + " -> "+entry.getValue());
            }
        }
        System.out.print(" }");

    }
}
