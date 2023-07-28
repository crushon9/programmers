package prog.java.Lv2;

/* 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
* 1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15*/

public class StraightNum {
    public static int solution(int n) {
        int answer = 0;

        int test = 0; // 자연수 n과 일치하는지 비교할 숫자
        for (int i = 1; i <= n; i++) { // i : 연속되는 자연수 중에서 첫번째 숫자
            for (int j = i; j <= n; j++) { 
                test = test + j; // i부터 n 사이에 1씩 증가하며 더하고
                if (test == n) { // n이랑 같으면 일치
                    answer++;
                    break;
                } else if (test > n) { // n보다 커지면 실패
                    test = 0; // 대조 숫자 초기화
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}