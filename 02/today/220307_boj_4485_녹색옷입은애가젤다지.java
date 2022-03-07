/**
 * 23400
 * 252
 */

import java.util.*;
import java.io.*;

public class Main {
    static int[][] map, arr;
    static int N;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int t = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
            arr[0][0] = map[0][0];
            bfs();
            sb.append("Problem " + t + ": " + arr[N - 1][N - 1] + "\n");
            t++;
        }
        System.out.println(sb);
    }

    static void bfs() {
        Deque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0));
        while (!queue.isEmpty()) {
            int nx, ny;
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (!checkRange(nx, ny))
                    continue;
                if (arr[nx][ny] <= arr[x][y] + map[nx][ny])
                    continue;
                arr[nx][ny] = arr[x][y] + map[nx][ny];
                queue.add(new Position(nx, ny));
            }
        }
    }

    static boolean checkRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N ? false : true;
    }

}
