import java.util.Scanner;

public class main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println((int)Math.pow(2,N)-1);
        hanoi(N,1,2,3);
        System.out.println(sb);
        sc.close();
    }

    static void hanoi(int n, int from, int temp, int to) {

        if (n == 0)
            return;

        hanoi(n - 1, from, to, temp);
        sb.append(from + " " + to+"\n");
        hanoi(n - 1, temp, from, to);

    }
}

