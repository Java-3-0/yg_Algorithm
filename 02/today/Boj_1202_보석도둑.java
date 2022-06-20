// 123028	1332
package boj;

import java.io.*;
import java.util.*;

public class Boj_1202_보석도둑 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 값
        }
        // 정렬
        Arrays.sort(jewels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 가방
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(bf.readLine());   // 최대무게
        }
        Arrays.sort(bags);

        long res = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx][0] <= bags[i]) {
                pq.offer(jewels[idx++][1]);
            }
            if (!pq.isEmpty())  res += pq.poll();
        }
        System.out.println(res);
    }
}

