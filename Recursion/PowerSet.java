package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        generateBit(str,0,"",list);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void generateBit(String str, int i, String string, List<String> list) {
        // TODO Auto-generated method stub
        int start =0;
        int end = (int)Math.pow(2, str.length());    
        while(start<end){
            int val = start;
            // check which bits are on the one which is on just take those characters.
            String s = "";
            int position=0;
            while(val>0){
                if((val&1)!=0){
                    s = s+str.charAt(position);
                }
                position++;
                val>>=1;
            }
            list.add(s);
            start++;
        }
    }

    // private static void generate(String str, int i, String ans, List<String> list) {
    //     // TODO Auto-generated method stub
    //     if(i == str.length()){
    //         list.add(ans);
    //         return;
    //     }
    //     generate(str, i+1, ans, list);
    //     generate(str, i+1, ans+str.charAt(i), list);
    // }
    
}
