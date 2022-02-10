import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

/*
 * 220210_boj_17298_오큰_수.java
 * 메모리 : 347,280kb
 * 시간 : 1,508ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        Stack<Integer> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            arr[s.pop()] = -1;
        }

        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}