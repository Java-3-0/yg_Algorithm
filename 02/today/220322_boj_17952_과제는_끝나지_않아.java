/**
 * 201288 kb
 * 1076 ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{

    public static class Node{
        int score;
        int cost;

        public Node(int score, int cost) {
            this.score = score;
            this.cost = cost;
        }
    }

    static Stack<Node> s;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        s = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (Integer.parseInt(st.nextToken()) == 1) {    // 과제가 존재할 때
                int score = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if (cost == 1)
                    res += score;
                else
                    s.push(new Node(score, cost - 1));
            } else {    // 과제가 없을때,
                if(s.isEmpty()) //밀린 과제도 없으면 패스
                    continue;
                Node node = s.pop();
                if(node.cost == 1)
                    res += node.score;
                else{
                    node.cost--;
                    s.push(node);
                }
            }
        }
        System.out.println(res);

    }
}
