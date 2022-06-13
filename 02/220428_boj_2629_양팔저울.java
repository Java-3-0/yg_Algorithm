/**
 * 13784 kb
 * 108 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] weights, marbles;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];   // 추
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        marbles = new int[M];   // 구슬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }
        StringBuffer sb = new StringBuffer();
        dp = new boolean[40000 + 1];

        // 가능한 무게 구하기
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(weights[i]);
            // 기존 상태에서 하나 더 올리기
            for (int j = 1; j <= 30 * 500; j++) {
                if (dp[j]) {
                    tmp.add(Math.abs(j - weights[i]));    // 구슬 쪽에 올리는 경우

                    if (j + weights[i] <= 30 * 500) {   // 구슬 반대 쪽에 올리는 경우
                        tmp.add(j + weights[i]);
                    }
                }
            }
            for (int j = 0; j < tmp.size(); j++) {
                dp[tmp.get(j)] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            sb.append(dp[marbles[i]] ? "Y" : "N");
            sb.append(" ");
        }
        
        System.out.println(sb);
    }
}
