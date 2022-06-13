// 94840 kb , 660 ms
package boj;

import java.util.*;
import java.io.*;

public class Boj_5430_AC {
    static int T, N;
    static String cmd;
    static Deque<Integer> deque;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            cmd = br.readLine();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            // 함수 부분
            boolean isReversed = false; // Deque 앞,뒤 구분
            boolean flag = true;    // 빈 배열 처리
            for (char c : cmd.toCharArray()) {
                // 버리기
                if (c == 'D') {
                    if (isReversed) {
                        if (deque.pollLast() == null) {
                            res.append("error").append("\n");
                            flag = false;
                            break;
                        }
                    } else {
                        if (deque.poll() == null) {
                            res.append("error").append("\n");
                            flag = false;
                            break;
                        }
                    }
                }
                // 뒤집기
                else if (c == 'R') {
                    isReversed = !isReversed;
                }
            }

            //  결과 처리
            if (!deque.isEmpty()) {
                res.append("[");
                if (!isReversed) {
                    res.append(deque.poll());

                    while (!deque.isEmpty()) {
                        res.append(",").append(deque.poll());
                    }
                } else {
                    res.append(deque.pollLast());

                    while (!deque.isEmpty()) {
                        res.append(",").append(deque.pollLast());
                    }
                }
                res.append("]").append("\n");
            }
            else{
                if(flag)
                    res.append("[]").append("\n");
            }
        }
        System.out.println(res);
    }
}
