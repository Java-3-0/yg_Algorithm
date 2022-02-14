/*
 * 2477.java
 * 메모리 : 14,140kb
 * 시간 : 120ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        int x1 = 0;  // 바깥 사각형 긴 변
        int y1 = 0;
        int x2 = 0; // 안쪽 사각형
        int y2 = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 6; i++) {
            if(arr[i] > x1) {
                x1 = arr[i];
                if (arr[(i + 5) % 6] > arr[(i + 1) % 6] ) {
                    y1 = arr[(i + 5) % 6];
                    x2 = arr[(i + 2) % 6];
                } else {
                    y1 = arr[(i + 1) % 6];
                    x2 = arr[(i + 4) % 6];
                }
                y2 = arr[(i + 3) % 6];
            }
        }
        int ans = (x1 * y1 - x2 * y2) * K;
        System.out.println(ans);
    }
}
