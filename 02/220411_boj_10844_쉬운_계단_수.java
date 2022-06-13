/**
 * 11496 kb
 * 80 ms
 */
import java.util.Scanner;

public class Main {
    static int N;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new long[N+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][1] % 1000000000;
                else if (j == 9)
                    dp[i][j] = dp[i-1][8] % 1000000000;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[N][i];
        }
        System.out.println(res % 1000000000);

    }
}
