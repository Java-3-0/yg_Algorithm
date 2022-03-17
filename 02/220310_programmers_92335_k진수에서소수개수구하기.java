class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n >= k){
            sb.insert(0,n%k);
            n /= k;
        }
        sb.insert(0,n);
        String change = sb.toString();
        long tmp = 0L;
        for(int i=0; i<change.length(); i++){
            if(change.charAt(i)=='0'){
                if(tmp != 0L && isPrime(tmp)){
                    ++answer;
                }
                tmp = 0L;
            }else{
                tmp = tmp*10 + change.charAt(i)-'0';
            }
        }
        if(tmp%10 != 0L && isPrime(tmp))
            answer++;

        return answer;
    }

    boolean isPrime(long num){
        if(num == 1)
            return false;
        int maxNum = (int)Math.sqrt(num);
        for(int i =2; i<= maxNum; i++){
            if(num % i == 0){
                return false;
            }

        }
        return true;
    }
}

