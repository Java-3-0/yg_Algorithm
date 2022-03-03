/**
 * 메모리 : 11956
 * 시간  : 84
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[7][2];    // 학년, 성별
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            arr[grade][sex]++;
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] == 0) continue;
                res += arr[i][j] / K;
                if(arr[i][j] % K != 0)
                    res++;
            }
        }
        System.out.println(res);
    }
}
