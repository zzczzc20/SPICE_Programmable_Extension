import java.util.*;

public class Main{
    public static void main(String args[]) {
        IntelligentLineDuplicater("C? nodei? nodeo? 50p", 200);
        MultiPortSubcktGenerator("name", "nodei1 nodei2?node102 nodei3");
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
    public static void MultiPortSubcktGenerator(String name, String portList) {
        String titLine = ".subckt " + name + " ";
        String endLine = ".ends " + name;
        for(int i = 0; i < portList.length(); i++){
            if(portList.charAt(i) == '?'){
                int tagIndex = i;
                int nameEndIndex = i;
                int DataEndIndex = i;
                int j;
                for(j = i + 1; (portList.charAt(j) >= 'a' && portList.charAt(j) <= 'z') || (portList.charAt(j) >= 'A' && portList.charAt(j) <= 'Z'); j++);
                nameEndIndex = j;
                for(;(j < portList.length()) && (portList.charAt(j) >= '0' && portList.charAt(j) <= '9'); j++);
                DataEndIndex = j;
                String portName = portList.substring(tagIndex + 1, nameEndIndex);
                int num = Integer.parseInt(portList.substring(nameEndIndex, DataEndIndex));
                String s1 = portList.substring(0, tagIndex);
                String s2 = portList.substring(DataEndIndex);
                for(int portPtr = 0; portPtr < num; portPtr++){
                    s1 = s1 + " " + portName + portPtr;
                }
                portList = s1 + s2;
            }
        }
        titLine = titLine + portList;
        System.out.println(titLine);
        System.out.println(endLine);
    }
}