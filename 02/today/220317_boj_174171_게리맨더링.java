/**
 *  kb
 *  ms
 */

import java.io.*;
import java.util.*;

public class Main{


    static int N;
    static int[] population;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int adjCnt = Integer.parseInt(st.nextToken());
            if( adjCnt > 0){
                for (int j = 0; j < adjCnt; j++) {
                    int adj = Integer.parseInt(st.nextToken());
                    graph[i][adj] = 1;
                    graph[adj][i] = 1;
                }
            }
        }

        // 

    }





}
