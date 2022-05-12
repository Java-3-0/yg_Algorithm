package boj;

import java.util.*;
import java.io.*;

public class Boj_16724_피리부는사나이 {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int cnt = 1;
        // 번호 매기기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                run(i, j, cnt);
            }
        }

        System.out.println(--cnt);
    }
    static void run(int i, int j, int cnt) {
        if(arr[i][j] != 'U' && arr[i][j] != 'D' && arr[i][j] != 'L' && arr[i][j] != 'R')
            return;

        int x = i;
        int y = j;

        while (true) {
            int dir[] = selectNext(arr[x][y]);
            // 현재 위치를 숫자로 변환
            arr[x][y] = cnt;
            int nx = x + dir[0];
            int ny = y + dir[1];

            // 다음 위치 범위 내 여부 판단
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == cnt) {
                System.out.println("!!!!!!!!!");
                for (int[] line: arr ) {
                    for (int k = 0; k < line.length; k++) {
                        System.out.print(line[k]+ " ");
                    }
                    System.out.println();
                }
                cnt++;
                break;
            }

            // 다음 위치 숫자로 변경하기
            x = nx;
            y = ny;
        }
    }
    static int[] selectNext(int now){
        if(now == 'U')
            return new int[]{-1,0};
        else if(now == 'D')
            return new int[]{1,0};
        else if(now == 'L')
            return new int[]{0,-1};
        else
            return new int[]{0,1};
    }
}

