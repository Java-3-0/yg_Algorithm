/**
 * 메모리 : 11488
 * 시간  : 84
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int x, y, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());


        boolean[] cutX = new boolean[x+1];    // 세로로 자르기
        boolean[] cutY = new boolean[y+1];    // 가로로 자르기

        // 자른 번호는 true로 저장하기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 0) {        // 가로로 자르기
                cutY[Integer.parseInt(st.nextToken())] = true;
            } else if (tmp == 1){  // 세로로 자르기
                cutX[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int maxX = 0;
        int maxY = 0;
        int tmp = 0;
        //가로의 최대 길이 구하기
        for (int i = 1; i <= x; i++) {
            tmp++;

            if (cutX[i] || i == x) {
                maxX = Math.max(tmp, maxX);
                tmp = 0;
            }
        }

        tmp = 0;
        //세의 최대 길이 구하기
        for (int i = 1; i <= y; i++) {
            tmp++;

            if (cutY[i] || i == y) {
                maxY = Math.max(tmp, maxY);
                tmp = 0;
            }
        }
        int res = maxX*maxY;
        System.out.println(res);

    }
}
