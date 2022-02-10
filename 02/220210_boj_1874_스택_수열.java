import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
 * 220210_boj_1874_스택_수열.java
 * 메모리 : 27,852kb
 * 시간 : 372ms
 */
public class Main {
    static int N;
    static Stack<Integer> s,res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        s= new Stack<>();

        N = Integer.parseInt(br.readLine());
        int now = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > now){
                for (int j = now + 1; j <= num; j++) {
                    s.push(j);
                    sb.append("+\n");
                }
                now = num;
            } else if (s.peek() != num) {
                System.out.println("NO");
                return;
            }

            s.pop();
            sb.append("-\n");

        }
        System.out.println(sb);

    }
}

