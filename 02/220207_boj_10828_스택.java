/*
 * 메모리 : 18224kb
 * 시간 : 380ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
        Stack<Integer> s = new Stack<>();
        s.push(i); // 스택의 값 넣기
        s.pop(); // 스택의 가장 위의 값 빼고 출력하기
        s.size(); // 스택의 크기
        s.peek(); // 스택의 가장 위의 값 조회
*/


public class Main {
    static int N;
    static Stack<Integer> s;
    static String command;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // stack 사용
        s = new Stack<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();

            //명령 구현
            switch (command) {
                case "push":
                    n = Integer.parseInt(st.nextToken());
                    s.push(n);
                    break;

                case "pop":
                    if (!s.empty())
                        System.out.println(s.pop());
                    else
                        System.out.println(-1);
                    break;

                case "size":
                    System.out.println(s.size());
                    break;

                case "empty":
                    if(s.empty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "top":
                    if (!s.empty())
                        System.out.println(s.peek());
                    else
                        System.out.println(-1);
                    break;
            }
        }
    }
}
