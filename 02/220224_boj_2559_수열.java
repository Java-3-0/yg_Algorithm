/**
 *  220224_boj_2559_수열.java
 *  시간   :  1292ms
 *  메모리 :  22,180KB
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] res;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        res = new int[N-(K-1)];
        for (int i = 0; i < N-(K-1); i++) {
            for (int j = i; j < i+ K; j++) {
                res[i] += arr[j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int num : res) {
            answer = Math.max(num, answer);
        }
        System.out.println(answer);


    }
}
