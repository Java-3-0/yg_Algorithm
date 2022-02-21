public class Main {

    // 올바른 문자열인지 판단
    static boolean isCorrect(String str){
        int balance = 0;

        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                balance++;
            else{
                if (balance == 0)
                    return false;

                balance--;
            }
        }
        return true;
    }

    static String[] divide(String w){

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int balance = 0;

        for( int i = 0; i < w.length(); i++){
            if(w.charAt(i) == '(')
                balance++;
            else
                balance--;

            if(balance == 0){
                u.append(w.substring(0, i + 1));
                v.append(w.substring(i+1, w.length()));
            }
        }
        String[] line = new String[2];
        line[0] = u.toString();
        line[1] = v.toString();

        return line;
    }


    static String reverse(String str){
        StringBuilder s = new StringBuilder();
        
        for(int i = 1; i<str.length()-1;i++){
            if(str.charAt(i) == '(') s.append(")");
            else s.append("(");
        }
        
        return s.toString();
    }
    

    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        // 1
        String answer = "";

        if(p.equals(""))
            return answer;

        // 2
        String[] line = divide(p);
        String u = line[0];
        String v = line[1];
        
        // 3
        if(isCorrect(u)){
            sb.append(answer).append(solution(v));
            answer = sb.toString();
        // 4
        }else {
            sb = new StringBuilder();

            // 4-1
            sb.append("(");
            // 4-2
            sb.append(solution(v));
            // 4-3
            sb.append(")");
            // 4-4
            sb.append(reverse(u.toString()));

            return sb.toString();

            }
            
        }
        
        return answer;
    }

    public static void main(String[] args) {

    }
}
