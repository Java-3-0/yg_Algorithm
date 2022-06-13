/**
 * 13136 kb
 * 112 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());


        if(N == 1)
            dp[1] = arr[1];
        else if(N==2)
            dp[2] = arr[1]+arr[2];
        else {
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));    // oox, oxo, xoo

            for (int i = 4; i <= N; i++)
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.println(dp[N]);
    }


}
