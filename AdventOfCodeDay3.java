import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AdventOfCodeDay3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        HashMap<Character,Integer>val=new HashMap<>();
        int count=1;
        for(char ch='a';ch<='z';ch++){
            val.put(ch,count);
            count++;
        }
        for(char ch='A';ch<='Z';ch++){
            val.put(ch,count);
            count++;
        }
        long sum=0;
        while(true){
            try{
                String s1=sc.nextLine();
                String s2=sc.nextLine();
                String s3=sc.nextLine();
                HashSet<Character> set1=new HashSet<>();
                HashSet<Character> set2=new HashSet<>();
                HashSet<Character> set3=new HashSet<>();
                for(int i=0;i<s1.length();i++){
                    set1.add(s1.charAt(i));
                }
                for(int i=0;i<s2.length();i++){
                    set2.add(s2.charAt(i));
                }
                for(int i=0;i<s3.length();i++){
                    set3.add(s3.charAt(i));
                }
                for(char ch:set1){
                    if(set2.contains(ch) && set3.contains(ch)){
                        sum+=val.get(ch);
                    }
                }

            }catch(Exception e){
                System.out.println(sum);
                break;
            }
        }
    }
}

