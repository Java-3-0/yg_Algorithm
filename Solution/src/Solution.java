/**
 * Solution_6808_규영이와_인영이의_카드게임_박영길.java
 * 메모리 : kb
 * 시간 : ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static boolean[] isSelected;
    static int[] numbers;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[] arr1 = new int[9];    // 규영 - 고정
            int[] arr2 = new int[9];    // 인영 - 변동

            // 규영 배열 초기화
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            // 인영 배열 초기화
            int N = 1;
            for (int i = 0; i < 9; i++) {
                    while(N == arr1[i]){
                        N++;
                    }
                    arr2[i] = N++;
            }

            isSelected = new boolean[9];
            numbers = new int[9];

            count = 0;
            cardGame(arr1,arr2,0);

            System.out.printf("#%d %d %d%n", tc, count, 362880-count);

        }

    }
    static void cardGame(int[] arr1, int[] arr2, int cnt){
        if (cnt == 9){
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < 9; i++) {
                if(arr1[i] > numbers[i])
                    sum1 += arr1[i] + numbers[i];
                else
                    sum2 += arr1[i] + numbers[i];
            }

            if(sum1 > sum2)
                count++;
            return;
        }

        else{
            for (int i = 0; i < 9; i++) {
                if (!isSelected[i]) {
                    numbers[cnt] = arr2[i];
                    isSelected[i] = true;
                    cardGame(arr1, arr2, cnt + 1);
                    isSelected[i] = false;
                }

            }

        }
    }
}
