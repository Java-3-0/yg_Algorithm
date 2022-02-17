import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 220217_boj_10158_개미_박영길.java
 * 11,568kb
 * 96ms
 */


public class Main {
    static int N;
    static boolean[][] isSelected;
    static int res;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                // 살아남으면 true
                isSelected[i][j] = (Integer.parseInt(st.nextToken()) - N >= 0)? true: false;
            }
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(0,0);
            }
        }


    }


    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        isSelected[r][c] = false;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내일 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (isSelected[nx][ny]) {
                        isSelected[nx][ny] = false;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }


    }


}
