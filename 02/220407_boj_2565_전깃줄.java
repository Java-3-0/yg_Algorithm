/**
 * 17972 kb
 * 228 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));

        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i ; j++) {
                if(arr[i][1] > arr[j][1] && dp[i] <= dp[j])
                    dp[i] = dp[j]+1;
            }
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if(res < dp[i])
                res = dp[i];
        }
        System.out.println(arr.length - res -1);
    }
}
