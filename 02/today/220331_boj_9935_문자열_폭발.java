/** 못품
 *  kb
 *  ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    static String str, bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder tmp = new StringBuilder();
        str = br.readLine();
        bomb = br.readLine();

        while (true) {
            StringTokenizer st = new StringTokenizer(str, bomb);
            tmp.setLength(0);
            while (st.hasMoreTokens()) {
                tmp.append(st.nextToken());
            }
            if(str.equals("")) {
                System.out.println("FRULA");
                break;
            }
            if(str.equals(tmp.toString())) {
                System.out.println(str);
                break;
            }
            str = tmp.toString();
        }
    }
}
