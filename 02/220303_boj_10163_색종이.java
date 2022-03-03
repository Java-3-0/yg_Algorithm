/**
 * 메모리 : 20440
 * 시간  : 384
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] arr;
    static int[] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for (int j = x; j < x+w ; j++) {
                for (int k = y; k < y+h; k++) {
                    arr[j][k] = i+1;
                }

            }
        }
        for (int i = 0; i < N; i++) {
            int res = 0;
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i+1) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }

    }
}
