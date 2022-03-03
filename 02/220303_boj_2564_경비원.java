/**
 * 메모리 : 11584
 * 시간  : 76
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int x, y, N;
    static int[] arr; // 북남서동 , 왼쪽부터 위부터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(dir == 1)
                arr[i] = dist;
            else if(dir == 2)
                arr[i] = x+y+x-dist;
            else if(dir == 3)
                arr[i] = x+y+x+y-dist;
            else
                arr[i] = x+dist;
        }
        int sum = 0;
        int donggeun = arr[N];

        int length = 0;
        for (int i = 0; i < N; i++) {
            length = Math.abs(donggeun-arr[i]);
            sum += Math.min(length, (x+y)*2-length);
        }
        System.out.println(sum);


    }
}
