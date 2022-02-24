/**
 *  Main_10157_자리배정_박영길.java
 *  시간   :  112ms
 *  메모리 :  15,864KB
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int C, R, K;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        arr = new int[R][C];
        int x = 0, y = 0;
        int dir = 0;

        while (true) {
            arr[x][y] = num;

            if( num == K ) {
                System.out.printf("%d %d", y+1, x+1);
                break;
            }
            if( num == R*C ) {
                System.out.println("0");
                break;
            }
            num++;

            int nx = x + dx[dir % 4];
            int ny = y + dy[dir % 4];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] != 0){
                dir++;
                nx = x + dx[dir % 4];
                ny = y + dy[dir % 4];
            }
            x = nx;
            y = ny;
        }
    }
}
