// 33932 kb, 368ms 
package boj;

import java.util.*;
import java.io.*;

public class Boj_16471_작은수내기 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[2][N];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);    // 정렬
        }

        // 이길확률 확인
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (i != N && j != N) {
            if(arr[0][i] < arr[1][j]) {
                cnt++;
                i++;
                j++;
            } else if (arr[0][i] == arr[1][j]) {
                j++;
            } else {
                j++;
            }
        }
        if(cnt >= (N+1)/2)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}

