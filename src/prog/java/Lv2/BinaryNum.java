package prog.java.Lv2;

/* 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
x의 모든 0을 제거합니다.
x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다.
s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를
각각 배열에 담아 return 하도록 solution 함수를 완성해주세요. */

import java.util.Arrays;

public class BinaryNum {

    /* answer은 배열이니깐 파라미터로 넘기면 주소값이 넘어가고
    변경시 힙영역의 데이터가 직접 변경됨
    다른 방법은 멤버변수로 static int를 선언해서 작업한뒤 answer에 담아도 됨*/
    public static int[] solution(String s) {
        int[] answer = {0, 0};

        String s1 = s;
        boolean flag = true;
        while (flag) {
            s1 = biCasting(removeZero(s1, answer), "", answer);
            if (s1.equals("1")) { // "1"이면 중지
                flag = false;
            }
        }

        return answer;
    }

    public static int removeZero(String s1, int[] answer) {
        int len = s1.length(); // 문자열 전체 갯수
        int cnt0 = 0; // 0의 갯수
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == '0') {
                cnt0++;
            }
        }
        answer[1] += cnt0; // 제거한 0의 갯수만큼 증가
        return len - cnt0; // 0을 제거한 1로만 이루어진 문자열의 길이를 biCasting의 파라미터로 넣어줌
    }

    public static String biCasting(int num, String str, int[] answer) {
        str = (num % 2) + str; // 파라미터를 2로 나눈 나머지를 변환문자열에 뒤에서부터 연결 (10진법 숫자를 2진법으로 변환)
        if (num / 2 > 0) { // 2로 나눈 몫이 0보다 크면 재귀함수
            return biCasting(num / 2, str, answer);
        } else {
            answer[0]++; // 2로 나눈 몫이 0이면 변환이 종료되었으므로 변환횟수를 증가시키고 변환문자열 반환
            return str;
        }
    }

 /*   public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        //System.out.println(biCasting(145));
    }*/
}