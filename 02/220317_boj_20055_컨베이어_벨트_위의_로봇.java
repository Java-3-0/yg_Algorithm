/**
 * 13264 kb
 * 248 ms
 */

import java.io.*;
import java.util.*;

public class Main{

    static int N, K;
    static int[] belt;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N];

        belt = new int[N*2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N * 2; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        int answer = process(0);
        System.out.println(answer);
    }


    public static int process(int step){

        while(true) {
            step++;

            //  벨트 한칸 회전
            int tmp = belt[2 * N - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];

            }
            belt[0] = tmp;

            // 로봇도 한칸 회전
            for (int i = N - 1; i > 0; i--)
                isSelected[i] = isSelected[i - 1];
            isSelected[0] = false;
            // 내리는 칸위의 로봇 내리기
            isSelected[N - 1] = false;

            // 로봇 이동
            for (int i = N - 2; i > 0; i--) {
                if (isSelected[i] && !isSelected[i + 1] && belt[i + 1] > 0) {
                    isSelected[i + 1] = true;
                    isSelected[i] = false;
                    belt[i + 1]--;
                }
            }

            // 올리는 위치에 로봇 올리기
            if (belt[0] > 0) {
                isSelected[0] = true;
                belt[0]--;
            }

            // 내구도 검사
            int cnt = 0;
            for (int i = 0; i < 2*N; i++) {
                if (belt[i] == 0)
                    cnt++;
                if(cnt >= K)
                    return step;
            }
        }
    }

}
