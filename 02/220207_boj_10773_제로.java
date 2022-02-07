/*
 * 메모리 : 23,180kb
 * 시간 : 256ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
        Stack<Integer> s = new Stack<>();
        s.push(i); // 스택의 값 넣기
        s.pop(); // 스택의 가장 위의 값 빼고 출력하기
        s.size(); // 스택의 크기
        s.peek(); // 스택의 가장 위의 값 조회
*/

public class Main {
    static int K;
    static Stack<Integer> s;
    static int n;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // stack 사용
        s = new Stack<>();
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            n = Integer.parseInt(br.readLine());

            if(n != 0) {
                sum += n;
                s.push(n);
            }
            else
                sum -= s.pop();
        }
        System.out.println(sum);
    }
}
