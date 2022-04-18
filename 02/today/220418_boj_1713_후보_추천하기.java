/**
 * 12412 kb
 * 100ms
 */

import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        int idx;
        int up;
        int t;

        public Student(int idx, int up, int t) {
            this.idx = idx;
            this.up = up;
            this.t = t;
        }

        @Override
        public int compareTo(Student o) {
            if (this.up == o.up) {
                // 추천수 같으면 시간정렬
                return this.t - o.t;
            }else
                // 추천수 정렬
                return this.up -o.up;
        }
    }

    static int N, CNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        CNT = Integer.parseInt(br.readLine());

        LinkedList<Student> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int cnt = 0; cnt < CNT; cnt++) {
            int tmp = Integer.parseInt(st.nextToken());
            boolean flag = false;
            // 사진틀에 있는지 확인
            for (Student s:list) {
                // 사진틀에 있는 경우
                if (s.idx == tmp) {
                    s.up++;
                    flag = true;
                    break;
                }
            }
            // 사진틀에 없는 경우
            if (!flag) {
                // 사진클이 꽉찬 경우
                if (list.size() == N)
                    list.remove(0);

                list.add(new Student(tmp, 1, cnt));
            }
            Collections.sort(list);
        }
        int[] res = new int[list.size()];
        // int[] res = new int[N > CNT ? CNT : N];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).idx;
        }
        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);

    }
}
