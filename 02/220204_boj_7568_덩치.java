import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] arr = new int[N][2];

        //배열 초기화
        for(int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        int[] rank = new int[N];
        for(int i = 0; i < N; i++) {
            rank[i] = 1;

            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank[i]++;
                }
            }
        }

        for(int i: rank){
            System.out.print(i+" ");
        }

    }
}
