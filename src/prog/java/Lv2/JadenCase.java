package prog.java.Lv2;

/* s는 길이 1 이상 200 이하인 문자열입니다.
s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
숫자는 단어의 첫 문자로만 나옵니다.
숫자로만 이루어진 단어는 없습니다.
공백문자가 연속해서 나올 수 있습니다.*/

public class JadenCase {
    public static String solution(String s) {
        String answer = "";
        // 대소문자 차이
        char gap = (char)('A' - 'a');
        // 첫번째 글자는 인덱스예외 땜에 반복문 밖에서 조건 검사
        if ('a' <= s.charAt(0) && s.charAt(0) <= 'z') {
            answer += (char)(s.charAt(0) + gap);
        } else {
            answer += s.charAt(0);
        }
        // 반복문으로 앞글자가 공백이고 뒷글자가영어인지 조건으로 검사
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && 'a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                answer += (char)(s.charAt(i) + gap);
            } else if (s.charAt(i - 1) != ' ' && 'A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                answer += (char)(s.charAt(i) - gap);
            } else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "for the last week";
        System.out.println(solution(s));
    }
}

/*
참고 풀이
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }*/
