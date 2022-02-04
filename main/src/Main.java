import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            //배열 채우기
            arr = new int[N][N];
            for (int i = 0; i < N; i++){
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                       arr[i][j] = s.charAt(j) - '0';
                }
            }

            //최댓값 구하기
            int max = 0;
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = 0; j < N-1; j++) {
                    sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
                    max = (sum > max)? sum : max;
                }
            }

            System.out.printf("#%d %d%n", tc, max);

        }


    }
}
