// 164800, 856

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr, dist;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2]; // 방문 여부
        dist = new int[N][M];   // 거리

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        if(N == 1 && M == 1)
            System.out.println(1);
        else
            bfs(0, 0);

    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j, 0});   // 시작점

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int flag = q.poll()[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위 검사
                if( nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                // 다음 칸 벽일 경우
                if (arr[nx][ny] == 1) {
                    if (flag == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][flag] = true;   // 방문처리
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    // 첫 방문일 경우
                    if (!visited[nx][ny][flag]) {
                        visited[nx][ny][flag] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny, flag});
                    }
                }

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(dist[nx][ny] + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
