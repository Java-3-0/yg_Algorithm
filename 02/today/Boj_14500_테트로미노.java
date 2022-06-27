// 33828 kb	568 ms
package boj;

import java.io.*;
import java.util.*;

public class Boj_14500_테트로미노 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // ㅗ ㅏ ㅜ ㅓ
    static int res = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                specialCase(i, j, 0);
            }
        }

        System.out.println(res);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void specialCase(int x, int y, int cnt) {
        int tmp = arr[x][y];
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            cnt ++;
            tmp += arr[nx][ny];
            minNum = Math.min(minNum, arr[nx][ny]);
        }
        if(cnt == 4)
            tmp -= minNum;

        res = Math.max(res, tmp);

    }
}

