import java.util.*;

public class Main{
    public static void main(String args[]) {
        String s = "C? nodei? nodeo? 50p";
        IntelligentLineDuplicater(s, 200);
    }
    public static void IntelligentLineDuplicater(String s, int num) {
        for(int lptr = 0; lptr < num; lptr++){
            String str = s;
            for(int i = 0; i < s.length(); i++){
                if(str.charAt(i) == '?'){
                    String s1 = str.substring(0, i);
                    String s2 = str.substring(i + 1);
                    str = s1 + lptr + s2;
                }
            }
            System.out.println(str);
        }
    }
}