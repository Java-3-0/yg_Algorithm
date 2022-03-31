import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 20940 kb
 * 180 ms
 */


public class Main{

    static int T, R, C;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new char[R][C];

            String s = null;
            for (int i = 0; i < R; i++) {
                s = br.readLine();
                arr[i] = s.toCharArray();
            }

            int answer = 0;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(j < C-2 && arr[i][j] == 62 && arr[i][j+1] == 'o' && arr[i][j+2] == '<')
                        answer++;
                    if(i < R - 2 && arr[i][j] == 'v' && arr[i+1][j] == 'o' && arr[i+2][j] == '^')
                        answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
