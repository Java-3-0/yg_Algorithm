/**
 * 메모리 : 11,560kb
 * 시간  : 84ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static boolean[] isBingoRow;
    static boolean[] isBingoCol;
    static boolean[] isBingoCross;
    static int bingoCnt = 0,cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        isBingoRow = new boolean[5];
        isBingoCol = new boolean[5];
        isBingoCross = new boolean[2];

        // 배열 초기화
        arr = new int[5][5];
        for( int i = 0; i < 5; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            for( int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙고 하나씩 맞추기
        loop:for( int i = 0; i < 5; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            for( int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                cnt++;

                // 배열에서 해당 숫자 찾기
                for(int x = 0; x < 5; x++ ){
                    for(int y = 0; y < 5; y++){
                        if(arr[x][y] == num)
                            arr[x][y] = 0;
                    }
                }

                int sum = 0;
                // 빙고 여부 확인하기 - 행
                for(int x = 0; x < 5; x++){
                    sum = 0;
                    for(int y = 0; y < 5; y++){
                        sum += arr[x][y];
                    }
                    if( sum == 0 && !isBingoRow[x]){
                        bingoCnt += 1;
                        isBingoRow[x] = true;
                    }


                }
                // 빙고 여부 확인하기 - 열
                for(int x = 0; x < 5; x++){
                    sum = 0;
                    for(int y = 0; y < 5; y++){
                        sum += arr[y][x];
                    }
                    if( sum == 0 && !isBingoCol[x]){
                        bingoCnt += 1;
                        isBingoCol[x] = true;
                    }

                }
                // 빙고 여부 확인하기 - \
                sum = 0;
                for(int x = 0; x < 5; x++)
                    sum += arr[x][x];
                if( sum == 0 && !isBingoCross[0]){
                    bingoCnt += 1;
                    isBingoCross[0] = true;
                }

                // 빙고 여부 확인하기 - /
                sum = 0;
                for(int x = 0; x < 5; x++)
                    sum += arr[x][4-x];

                if( sum == 0 && !isBingoCross[1]){
                    bingoCnt += 1;
                    isBingoCross[1] = true;
                }

                if (bingoCnt >= 3){
                    break loop;
                }

            }
        }
        System.out.println(cnt);
    }
}

