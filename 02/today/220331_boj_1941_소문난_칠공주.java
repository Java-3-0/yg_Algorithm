import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 52548 kb
 * 272 ms
 */


public class Main{
    static char[][] arr;
    static int[] students;
    static boolean[] visited;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        students = new int[7];
        combination(0,0,0);
        System.out.println(answer);


    }

    static void combination(int cnt, int start, int cntY){

        if(cntY == 4)
            return;

        if(cnt == 7){
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            students[cnt] = i;
            combination(cnt+1, i+1, arr[i/5][i%5] == 'Y'? cntY+1 : cntY );
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[7];

        q.offer(students[0]);
        visited[0] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            int x = now / 5;
            int y = now % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                    continue;

                int nextStudent = nx * 5 + ny;

                for (int j = 0; j < 7; j++) {
                    if (nextStudent == students[j] && !visited[j]) {
                        q.offer(nextStudent);
                        visited[j] = true;
                        cnt++;
                    }
                }
            }
        }

        if(cnt == 7)
            answer++;

    }

}
