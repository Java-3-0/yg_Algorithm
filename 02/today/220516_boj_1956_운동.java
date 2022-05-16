// 67416 kb, 732 ms
package boj;

import java.io.*;
import java.util.*;

public class Boj_1956_운동 {
    static int V, E;
    static int[][] arr;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new int[V+1][V+1];

        // 초기화
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[from][to] = cost;
        }
        // 프로이드 와샬
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    res = Math.min(res, arr[i][j] + arr[j][i]);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }


    }
}

