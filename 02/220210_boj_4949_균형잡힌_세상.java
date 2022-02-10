import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 220210_boj_4949_균형잡힌_세상.java
 * 메모리 : 19,116kb
 * 시간 : 232ms
 */
public class Main {
    static int N;
    static int[] arr;
    static Stack<Character> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line = "";
        while (! (line = br.readLine()).equals("."))  {
            // 초기화
            s = new Stack<>();
            boolean b = true;

            for (int i = 0; i < line.length(); i++) {
                char tmp = line.charAt(i);
                if (tmp == '(' || tmp == '[')
                    s.push(tmp);
                else if (tmp == ')') {
                    if ((s.isEmpty() || s.peek() != '(')) {
                        b = false;
                        break;
                    } else
                        s.pop();
                } else if (tmp == ']') {
                    if ((s.isEmpty() || s.peek() != '[')) {
                        b = false;
                        break;
                    } else
                        s.pop();
                }
            }
            if(s.isEmpty() && b)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}

