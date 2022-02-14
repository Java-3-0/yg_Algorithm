/*
 * .java
 * 메모리 : 34,720kb
 * 시간 : 134ms
 */

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = -100;
        int temp = 0;


        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        int x = 0;
        int y = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]+ arr[j] == sum) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(i == x || i == y )
                continue;
            else
                System.out.println(arr[i]);

        }




    }
}
