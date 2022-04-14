import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 이분탐색을 위한 정렬
        Arrays.sort(arr);

        int start = 1;  // 최소 거리
        int end = arr[N-1] - arr[0];    // 최대 거리

        int res = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int house = arr[0]; // 집
            int cnt = 1;    // 초기 거리
            // 공유기 설치
            for (int i = 1; i < N; i++) {
                if (arr[i] >= house + mid) {
                    house = arr[i];
                    cnt++;
                }
            }

            // C개 이상의 공유기를 설치하면, 거리 증가
            if (cnt >= C) {
                start = mid + 1;
                res = mid;
            } else {    // 없으면 거리 감소
                end = mid -1;
            }

        }
        System.out.println(res);

    }
}
