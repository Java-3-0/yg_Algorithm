class Solution {
    static int[][] dp;

    public int solution(int[] money) {
        int answer = 0;

        dp = new int[2][money.length]; // 1 : 첫번째 집 털음, 0 : 안털음
        dp[0][1] = money[1];
        dp[0][2] = Math.max(money[1], money[2]);
        dp[1][0] = money[0];
        dp[1][2] = money[0] + money[2];
        if(money.length == 3)
            return Math.max(Math.max(money[0], money[1]), money[2]);
        else{
            for(int i = 3; i < money.length; i++){
                dp[0][i] = Math.max(dp[0][i-2], dp[0][i-3] + money[i]);

                if(i == money.length -1) continue;  // 마지막 집이 선택되면 continue

                dp[1][i] = Math.max(dp[1][i-2], dp[1][i-3] + money[i]);
            }

            answer = Math.max( Math.max(dp[0][money.length-1], dp[0][money.length-2]), Math.max(dp[1][money.length-2], dp[0][money.length-3]));
            System.out.println(answer);
            return answer;   
        }
        
    }
}
