/**
 * 메모리 12200
 * 시간 84
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D, distance[], INF = Integer.MAX_VALUE;
    static List<Node> graph[];

    static class Node {
        int e;
        int v;
        public Node(int e, int v) {
            super();
            this.e = e;
            this.v = v;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        distance = new int[10001];
        graph = new List[10001];
        for(int i=0; i<graph.length; i++) {
            distance[i] = i;
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, d));
        }
        dijkstra(0);

        System.out.println(distance[D]);
    }
    private static void dijkstra(int start) {
        if(start > D) {
            return;
        }
        if(distance[start+1] > distance[start] + 1) {
            distance[start+1] = distance[start] + 1;
        }

        for(int i=0; i<graph[start].size(); i++) {
            if(distance[start] + graph[start].get(i).v < distance[graph[start].get(i).e]) {
                distance[graph[start].get(i).e] = distance[start] + graph[start].get(i).v;
            }
        }
        dijkstra(start+1);
    }

}
