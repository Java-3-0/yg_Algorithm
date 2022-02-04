import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        boolean[][] chess = new boolean[N][M];
        int min = 64;

        //배열 입력 : W - true , B - false
        for (int i = 0; i < N; i++) {
            String str = scan.next();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    chess[i][j] = true;
                } else {
                    chess[i][j] = false;
                }
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int count = 0;

                boolean temp = true    // 기준

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        // 다른색이면 증가
                        if (chess[k][l] == temp) {
                            count++;
                        }
                        temp = (!temp);
                    }
                    temp = (!temp);
                }

                count = Math.min(count, 64 - count);
                min = Math.min(min, count);
            }
        }
        
        System.out.println(min);
    }

}

