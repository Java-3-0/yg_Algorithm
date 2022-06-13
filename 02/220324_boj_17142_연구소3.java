/**
 * 43604 kb
 * 224 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1 ,0, -1};

    static int N, M;
    static int[][] arr;
    static List<Point> virus = new ArrayList<>();
    static int[][] tmp, visited;
    static int res = Integer.MAX_VALUE;
    static int count = 0;
    static int a = 0;

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void combination(int index, int cnt){
        a++;
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = index; i < virus.size(); i++) {
            Point p = virus.get(i);
            arr[p.x][p.y] = 9;  // 바이러스 활성화
            combination(i + 1, cnt + 1);    // 다음 활성화할 바이러스 선택
            arr[p.x][p.y] = 2;  // 복구
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visited = new int[N][N];

        tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[i][j];

                if (tmp[i][j] == 9) {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int infectedArea = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || tmp[nx][ny] == 1) continue;

                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Point(nx, ny));

                    if(tmp[nx][ny] == 0) infectedArea++;

                    if(infectedArea == count)
                        res = Math.min(res, visited[nx][ny]-1);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0)
                    count++;

                if (arr[i][j] == 2)
                    virus.add(new Point(i, j));
            }
        }

        if (count == 0)
            res = 0;
        else
            combination(0,0);

        if(res == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res);

    }
}
