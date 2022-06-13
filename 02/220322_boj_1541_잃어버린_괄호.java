/**
 * 11548 kb
 * 76 ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int res = 0;


        StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
        while(st2.hasMoreTokens()){
            res += Integer.parseInt(st2.nextToken());
        }

        while(st.hasMoreTokens()){
            st2 = new StringTokenizer(st.nextToken(), "+");
            int tmp = 0;
            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }
            res -= tmp;
        }
        System.out.println(res);
    }
}
