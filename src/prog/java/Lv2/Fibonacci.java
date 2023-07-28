package prog.java.Lv2;

/* 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요. */

public class Fibonacci {
    public static int solution(int n) {

        int ppre = 0;
        int pre = 1;
        int fibo = 0;
        for (int i = 1; i < n; i++) {
            // int 오버플로우 때문에 숫자 조정
            ppre = ppre % 1234567;
            pre = pre % 1234567;
            fibo = ppre + pre;
            ppre = pre;
            pre = fibo;
        }

        return fibo % 1234567;
    }

    public static void main(String[] args) {

        System.out.println(solution(7));
    }
}