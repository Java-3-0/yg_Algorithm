//
package boj;

import java.util.*;

public class Boj_2504_괄호의값 {
    static String str;
    static Stack<Character> s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        s = new Stack<>();

        int tmp = 1;
        int res = 0;
        Loop : for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {

                case '(':
                    s.push('(');
                    tmp *= 2;
                    break;

                case '[':
                    s.push('[');
                    tmp *= 3;
                    break;

                case ')':
                    if (s.isEmpty() || s.peek() != '(') {
                        res = 0;
                        break Loop;
                    }

                    if (str.charAt(i - 1) == '(')
                        res += tmp;
                    s.pop();
                    tmp /= 2;
                    break;

                case ']':
                    if (s.isEmpty() || s.peek() != '[') {
                        res = 0;
                        break Loop;
                    }

                    if (str.charAt(i - 1) == '[')
                        res += tmp;
                    s.pop();
                    tmp /= 3;
                    break;
            }
        }
        if(!s.isEmpty())
            res = 0;
        System.out.println(res);
    }

}


// 2 * 2
