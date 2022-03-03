/**
 * 메모리 : 26948
 * 시간  : 316
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int T;
    static int[][] arr; // A,B / 딱지모양

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            arr = new int[2][4];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                while (st.hasMoreTokens()) {
                    arr[i][Integer.parseInt(st.nextToken())-1]++;
                }
            }
            if (arr[0][3] > arr[1][3]) {
                System.out.println("A");
            }else if(arr[0][3] < arr[1][3]) {
                System.out.println("B");
            }else if (arr[0][2] > arr[1][2]) {
                System.out.println("A");
            }else if(arr[0][2] < arr[1][2]) {
                System.out.println("B");
            }else if (arr[0][1] > arr[1][1]) {
                System.out.println("A");
            }else if(arr[0][1] < arr[1][1]) {
                System.out.println("B");
            }else if (arr[0][0] > arr[1][0]) {
                System.out.println("A");
            }else if(arr[0][0] < arr[1][0]) {
                System.out.println("B");
            }else
                System.out.println("D");

        }
    }
}
