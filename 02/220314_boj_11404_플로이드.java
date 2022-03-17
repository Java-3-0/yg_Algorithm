import java.util.Scanner;

class Main {
    private static int n; 
    private static int m; 
    private static int[][] distance; // 최소비용
    private static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distance = new int[n + 1][n + 1];

        //초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }
        
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            distance[start][end] = Math.min(distance[start][end], weight);
        }

        for (int k = 1; k <= n; k++) { 
            for (int i = 1; i <= n; i++) { 
                for (int j = 1; j <= n; j++) { 
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]); 
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] >= INF) {
                    sb.append("0 ");
                } else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    
}
