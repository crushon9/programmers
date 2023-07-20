package java.Lv2;

public class CorrectBracket {
    boolean solution(String s) {
        boolean answer = true;
        if (s.length() % 2 == 1) {
            return false;
        } else {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (sum == 0 && s.charAt(i) == ')') {
                    return false;
                }
                if (s.charAt(i) == '(') {
                    sum += 1;
                } else {
                    sum -= 1;
                }
            }
            answer = sum == 0 ? true : false;
        }
        return answer;
    }
}