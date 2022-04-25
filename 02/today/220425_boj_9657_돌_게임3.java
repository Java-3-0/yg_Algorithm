/*
 * 12864 kb
 * 108 ms
 */
import java.util.*;

public class Main {
    static int N;
    static boolean[] dp;    // true : SK , false : CY

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if(N < 4)
            dp = new boolean[4+1];
        else
            dp = new boolean[N+1];

        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        
        // 전 턴에 무조건 상대방이 이기면 패배 확정
        for (int i = 5; i <= N; i++) {
            dp[i] = dp[i-1] && dp[i-3] && dp[i-4] == true ? false : true;
        }

        if (dp[N])
            System.out.println("SK");
        else
            System.out.println("CY");

    }
}
