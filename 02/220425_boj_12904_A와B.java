/**
 * 16464 kb
 * 128 ms
 */

import java.util.*;

public class Main {
    static String  S, T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        T = sc.nextLine();

        if(beforeStep(T))
            System.out.println(1);
        else
            System.out.println(0);

    }
    public static boolean beforeStep(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S))
                return true;
            else
                return false;
        }

        // 마지막 글자 A -> 그냥 A 추가한 경우
        if (str.charAt(str.length()-1) == 'A') {
            str = str.substring(0, str.length() - 1);
            return beforeStep(str);
        } else {
            // 마지막 글자 B -> 뒤집고 B 추가한 경우
            str = str.substring(0, str.length() - 1);
            StringBuffer sb = new StringBuffer(str);
            str = sb.reverse().toString();
            return beforeStep(str);
        }
    }
}
