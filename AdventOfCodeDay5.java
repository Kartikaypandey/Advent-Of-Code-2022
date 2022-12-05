import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class AdventOfCodeDay5 {
    public static void main(String[] args) {
        // Solution 1 - SFWHFFWGC
        // Solution 2 - PWPWHGFZS
        Scanner sc=new Scanner(System.in);
        List<Stack<Character>> res=new ArrayList<>();
        String[]arr=new String[9];
        arr[0]="CFBLDPZS";
        arr[1]="BWHPGVN";
        arr[2]="GJBWF";
        arr[3]="SCWLFNJG";
        arr[4]="HSMPTLJW";
        arr[5]="SFGWCB";
        arr[6]="WBQMPTH";
        arr[7]="TWSF";
        arr[8]="RCN";
        for (String value : arr) {
            Stack<Character> s = new Stack<>();
            for (int j = value.length() - 1; j >= 0; j--) {
                s.push(value.charAt(j));
            }
            res.add(s);
        }
        while(true){
            try{
                String s = sc.nextLine();
                if(s.contains("move")){
                    String[]move=s.split(" ");
                    int num=Integer.parseInt(move[1]);
                    int src=Integer.parseInt(move[3])-1;
                    int dst=Integer.parseInt(move[5])-1;
                    Stack<Character>source=res.get(src);
                    Stack<Character>destination=res.get(dst);
                    int count=0;
                    Stack<Character>temp=new Stack<>();
                    while(count<num){
                        char ch = source.pop();
                        temp.add(ch);
                        count++;
                    }
                    // For Solution 1 , No Need of temp stack
                    // Add elements in the Above while loop only
                    while(!temp.isEmpty()){
                        destination.push(temp.pop());
                    }
                }
            }catch(Exception e){
                System.out.println("END");
                StringBuilder sb=new StringBuilder();
                for (Stack<Character> re : res) {
                    sb.append(re.pop());
                }
                System.out.println(sb);
                break;
            }
        }
    }
}


