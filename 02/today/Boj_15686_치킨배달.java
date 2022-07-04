package boj;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_15686_치킨배달 {
    static int N, M;
    static int[][] arr;
    static ArrayList<Point> house, chicken;
    static boolean[] selected;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        selected = new boolean[chicken.size()];
        comb(0, 0);
        System.out.println(res);
    }

    public static void comb(int start, int depth) {
        if (depth == M) {
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int x = house.get(i).x;
                int y = house.get(i).y;
                int minD = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (selected[j]) {
                        int dist = Math.abs(house.get(i).x - house.get(j).x) + Math.abs(house.get(i).y - house.get(j).y);

                        minD = Math.min(minD, dist);
                    }
                }
                sum += minD;
            }
            res = Math.min(res, sum);
            return;
        }

        for (int i = 0; i < chicken.size(); i++) {
            selected[i] = true;
            comb(i + 1, depth + 1);
            selected[i] = false;
        }
    }
}
