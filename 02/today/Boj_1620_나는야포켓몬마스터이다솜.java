// 62940	548
package boj;

import java.util.*;
import java.io.*;

public class Boj_1620_나는야포켓몬마스터이다솜 {
    static int N, M;
    static HashMap<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(Integer.toString(i), str);
            map.put(str, Integer.toString(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}

