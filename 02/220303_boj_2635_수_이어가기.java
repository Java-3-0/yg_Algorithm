/**
 * 메모리 : 12860
 * 시간  : 108
 */

import java.io.IOException;
import java.util.Scanner;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int res = 0;
        int num = 0;
        for (int secondNum = 1; secondNum <= N; secondNum++) {
            int cnt = 2;
            int a = N;
            int b = secondNum;
            while (true) {
                if (a < b){
                    if (res < cnt) {
                        res = cnt;
                        num = secondNum;
                    }
                    break;
                } else {
                    int tmp = a;
                    a = b;
                    b = tmp-b;
                    cnt++;
                }
            }
        }
        System.out.println(res);
        sb.append(N).append(" ").append(num).append(" ");

        int a = N;
        int b = num;
        while (a-b>=0) {
            sb.append(a-b).append(" ");
            int tmp = a;
            a = b;
            b = tmp-b;
        }
        System.out.println(sb);

    }
}
