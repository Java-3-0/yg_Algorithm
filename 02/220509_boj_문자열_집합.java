package boj;

import java.util.*;
import java.io.*;

public class Boj_14425_문자열집합 {
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (map.get(br.readLine()) != null) {
            // if (map.containsKey(br.readLine())) {
                cnt++;
            }

        }
        System.out.println(cnt);
    }

}

