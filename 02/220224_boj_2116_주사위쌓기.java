/**
 *  220224_boj_2116_주사위쌓기.java
 *  시간   :  228ms
 *  메모리 :  20,840KB
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = 0;
    static Integer[][] cubes;
    static int[] oppositeSide = {5, 3, 4, 1, 2, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());

        cubes = new Integer[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 6; j++)
                cubes[i][j] = Integer.parseInt(st.nextToken());
        }
        // i번째 면이 밑면일 경우
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            int bottom = cubes[0][i];
            int top = cubes[0][oppositeSide[i]];
            sum += getMaxNum(bottom, top);

            for (int j = 1; j < N; j++) {
                bottom = top;
                top = cubes[j][oppositeSide[Arrays.asList(cubes[j]).indexOf(bottom)]];
                sum += getMaxNum(bottom, top);
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }

    static int getMaxNum(int bottom, int top ) {
        if(top + bottom == 11)
            return 4;
        else if( bottom == 6 || top == 6)
            return 5;
        else
            return 6;

    }
}
