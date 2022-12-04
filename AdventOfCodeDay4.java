import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AdventOfCodeDay4 {
    public static void main(String[] args) {
        // SOLUTION -
        // 1) 588
        // 2) 911
        Scanner sc =new Scanner(System.in);
        int count=0;
        while(true){
            try{
                String s=sc.nextLine();
                String[]arr=s.split(",");
                String[]first=arr[0].split("-");
                String[]second=arr[1].split("-");
                int v1=Integer.parseInt(first[0]);
                int v2=Integer.parseInt(first[1]);
                int v3=Integer.parseInt(second[0]);
                int v4=Integer.parseInt(second[1]);
                if(v1<=v3 && v3<=v2 || v1<=v4 && v4<=v2 || v3<=v1 && v1<=v4 || v3<=v2 && v2 <=v4){
                    count++;
                }
            }catch(Exception e){
                System.out.println(count);
                break;
            }
        }
    }
}

