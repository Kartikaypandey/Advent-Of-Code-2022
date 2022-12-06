import java.util.HashSet;
import java.util.Scanner;

public class AdventOfCodeDay6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[26];
        int sol = 0;
        while (true) {
            try {
                String s = sc.nextLine();
                System.out.println(s + " " + s.length());
                for (int i = 0; i < 14; i++) count[s.charAt(i) - 'a']++;
                if (isPossible(count)) {
                    sol = 14;
                } else {
                    for (int i = 14; i < s.length(); i++) {
                        count[s.charAt(i - 14) - 'a']--;
                        count[s.charAt(i) - 'a']++;
                        if (isPossible(count)) {
                            sol = i + 1;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(sol);
                break;
            }
        }
    }

    private static boolean isPossible(int[] count) {
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) total++;
        }
        return total == 14;
    }
}

