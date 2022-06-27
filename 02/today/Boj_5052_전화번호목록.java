// 32560kb	504ms
package boj;

import java.io.*;
import java.util.*;

public class Boj_5052_전화번호목록 {
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);

            boolean flag = true;
            for (int i = 0; i < N-1; i++) {
                if (arr[i+1].length() > arr[i].length() && arr[i].equals(arr[i + 1].substring(0, arr[i].length()))) {
                    sb.append("NO").append("\n");
                    flag = false;
                    break;
                }
            }
            if(flag)
                sb.append("YES").append("\n");
        }
        System.out.println(sb);
    }
}
