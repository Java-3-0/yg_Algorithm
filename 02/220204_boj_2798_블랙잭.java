import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int ans = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                for (int k = j + 1; k < arr.length; k++)
                    if (arr[i] + arr[j] + arr[k] <= M && arr[i] + arr[j] + arr[k] > ans)
                        ans = arr[i] + arr[j] + arr[k];

        System.out.println(ans);

    }
}

