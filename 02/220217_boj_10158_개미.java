import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 220217_boj_10158_개미_박영길.java
 * 11,568kb
 * 96ms
 */


public class Main {
    static int W;
    static int H;

    // 좌우 부딫힘 : y값 반전
    // 상하 부딪힘 : x값 반전
    // 4 5 6 5 4 3 2 1 0 1 2 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());

        x = W - Math.abs(W - (x+T)%(W*2));
        y = H - Math.abs(H - (y+T)%(H*2));

        System.out.println(x+ " "+ y);
    }


}
