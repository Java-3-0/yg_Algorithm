package boj;

import java.util.*;
import java.io.*;

/**
 *  k+1    1 2 ... k    k+2
 *  첫 수 : k+1 : k개
 *  둘째 수 : k+1 개
 *  5 4 1 2 3
 *
 * 1 ... N
 * N 1...N-1
 */

public class Boj_20921_그렇고그런사이 {
    static int N, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (K >= 0) {
            if (K + 1 <= N) {
                recursion();
                break;
            } else {
                sb.append(N).append(" ");

                K -= N-1;
                N -=1;
            }
        }
        System.out.println(sb);
    }

    public static void recursion() {
        sb.append(K+1).append(" ");
        for (int i = 1; i <= N; i++) {
            if (i == K + 1) continue;
            sb.append(i).append(" ");
        }
    }
}


