/**
 * 메모리 : 21,420kb
 * 시간  : 204ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 배열 초기화
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int res = 1;
        // 커질때
        int tmp = 1;
        for (int i = 0; i < N-1; i++) {
            if(arr[i] <= arr[i+1])
                tmp++;
            else
                tmp = 1;

            res = Math.max(res,tmp);
        }

        // 작아질 때
        tmp = 1;
        for (int i = 0; i < N-1; i++) {
            if(arr[i] >= arr[i+1])
                tmp++;
            else
                tmp = 1;

            res = Math.max(res,tmp);
        }

        System.out.println(res);

    }
}

