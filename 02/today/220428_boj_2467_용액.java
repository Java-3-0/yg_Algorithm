/**
 * 31300 kb
 * 288 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int res1, res2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            int fluid = arr[i]; // 기준 용액
            int startIdx = i+1;
            int endIdx = N-1;
            while (startIdx <= endIdx) {
                int midIdx = (startIdx + endIdx) / 2;

                if(Math.abs(fluid + arr[midIdx]) < maxValue){
                    maxValue = Math.abs(Math.abs(fluid + arr[midIdx]));
                    res1 = fluid;
                    res2 = arr[midIdx];
                }
                if(fluid + arr[midIdx] < 0)
                    startIdx = midIdx + 1;
                else
                    endIdx = midIdx - 1;
            }
        }
        System.out.println(res1 + " "+ res2);
    }


}
