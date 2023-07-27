package prog.java.Lv2;

/* 길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다.
이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
(단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.). */

import java.util.Arrays;

public class Min {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 가장작은값과 큰값곱해서 누적하기
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution(A, B));
    }
}