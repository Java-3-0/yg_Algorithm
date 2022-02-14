/*
 * .java
 * 메모리 : 14,132kb
 * 시간 : 132ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            list.add(i - arr[i], i + 1);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}
