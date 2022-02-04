import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = factorial(N);
        System.out.println(ans);

    }
    public static int factorial(int num){
        if(num == 1 || num == 0)
            return 1;
        else
            return num * factorial(num-1);
    }
}

