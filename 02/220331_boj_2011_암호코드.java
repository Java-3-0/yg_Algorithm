/** 
 * 13652 kb
 * 124 ms
 */


import java.io.IOException;
import java.util.*;


public class Main{
    static long[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String pwd = sc.nextLine();
        dp = new long[pwd.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        if (pwd.charAt(0) == '0') {
            System.out.println(0);

        }else {

            for (int i = 2; i <= pwd.length(); i++) {
                char now = pwd.charAt(i - 1); // i번째 문자
                char before = pwd.charAt(i - 2);  // i-1번째 문자

                if (now == '0') {
                    if (before == '1' || before == '2')
                        dp[i] = dp[i - 2] % 1000000;
                    else
                        break;

                } else {
                    if (before == '0') {
                        dp[i] = dp[i - 1] % 1000000;
                    } else {
                        int tmp = (before - '0') * 10 + now - '0';
                        if (tmp >= 1 && tmp <= 26)
                            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                        else
                            dp[i] = dp[i - 1] % 1000000;

                    }

                }

            }
            System.out.println(dp[pwd.length()] % 1000000);
        }
    }
}
