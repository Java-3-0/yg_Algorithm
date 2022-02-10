/*
 * 메모리 : 14,192kb
 * 시간 : 124ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++) {
            String line = br.readLine();
            int res = 0;

            for (int i = 0; i < line.length(); i++) {
               if(line.charAt(i) == '(')
                   res++;
               else
                   res --;

               if(res < 0){
                   sb.append("NO\n");
                   break;
               }
            }
            if(res == 0)
                sb.append("YES\n");
            else if(res > 0)
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}


/*
 * 메모리 : 14,280kb
 * 시간 : 132ms


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;


public class Main {
    static int N;
    static char tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++) {
            String line = br.readLine();
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                tmp = line.charAt(i);
                if(tmp == '('){
                    s.push(tmp);
                }
                else {
                    if(s.isEmpty()) {
                        sb.append("NO\n");
                        break;
                    }else
                        s.pop();
                }
                if(i == line.length()-1)
                    if( s.isEmpty())
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
 */
