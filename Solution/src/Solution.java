/**
 * Solution_1233_사칙연산_유효성_검사_박영길.java
 * 메모리 : 18,708kb
 * 시간 : 135ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int res = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();

                char node = st.nextToken().charAt(0);
                // 단말 노드일 때
                if(!st.hasMoreTokens()){
                    if(node < '0' || node > '9')
                        res = 0;
                 }else{
                    if(!(node == '+' || node == '-' || node == '*' || node == '/'))
                        res = 0;
                }
            }
            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb);
    }
}
