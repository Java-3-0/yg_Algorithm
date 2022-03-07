/**
 * 메모리 : 11964
 * 시간  : 100
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1001];
        int startPoint = 1000, endPoint = 0;
        int maxHeight = 0, fromX = 0, toX = 0;

        // 다각형 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[x] = height;
            startPoint = Math.min(startPoint, x);
            endPoint = Math.max(endPoint, x);
            maxHeight = Math.max(maxHeight, height);
        }

        // 최고높이 다각형의 시작,끝 조사
        for (int i = startPoint; i <= endPoint; i++) {
            if(arr[i] == maxHeight) {
                fromX = i;
                break;
            }
        }

        for (int i = endPoint; i >= startPoint; i--){
            if(arr[i] == maxHeight) {
                toX = i;
                break;
            }
        }

        // 창고 넓이 구하기
        int sum = 0;
        int addAmount = arr[startPoint];
        for (int i = startPoint; i < fromX ; i++) {
            if(arr[i]> addAmount)
                addAmount = arr[i];
            sum += addAmount;
            //System.out.printf("%d만큼 더합니다.%n",addAmount);
        }
        //System.out.println("");

        addAmount = arr[endPoint];
        for (int i = endPoint; i >= toX ; i--) {
            if(arr[i] > addAmount)
                addAmount = arr[i];
            sum += addAmount;
            //System.out.printf("%d만큼 더합니다.%n",addAmount);
        }
        sum +=  (toX-fromX)*maxHeight;

        System.out.println(sum);

    }
}
