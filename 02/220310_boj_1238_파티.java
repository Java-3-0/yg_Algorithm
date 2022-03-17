
/**
 * 17100kb
 * 172ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class village implements Comparable<village> {
    int end;
    int weight;

    village(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(village o) {
        return weight - o.weight;
    }
}

public class Main {
    static final int INF = 99999999;
    static ArrayList<ArrayList<village>> arr, arrReverse;
    static int N, X;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        arrReverse = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            arrReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr.get(start).add(new village(end, weight));
            arrReverse.get(end).add(new village(start, weight));
        }

        int[] dist1 = dijkstra(arr);
        int[] dist2 = dijkstra(arrReverse);

        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dist1[i] + dist2[i]);
        }

        sb.append(res).append("\n");
        System.out.println(sb);

    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(ArrayList<ArrayList<village>> a) {
        PriorityQueue<village> pq = new PriorityQueue<>();
        pq.offer(new village(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            village now = pq.poll();
            int current = now.end;

            if (!check[current]) {
                check[current] = true;

                for (village v : a.get(current)) {
                    if (!check[v.end] && dist[v.end] > dist[current] + v.weight) {
                        dist[v.end] = dist[current] + v.weight;
                        pq.add(new village(v.end, dist[v.end]));
                    }
                }
            }
        }
        return dist;
    }

}

