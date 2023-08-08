package prog.java.Lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class HanoiTower {
    ArrayList<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size()][];
        int i = 0;
        for (int[] x : list) {
            answer[i] = x;
            i++;
        }

        return answer;
    }

    public void hanoi(int n, int from, int temp, int to) {
        if (n == 1) { // 원반이 하나만 있을 때는 (재귀 탈출 조건)
            int[] arr = {from, to}; // 그냥 목표지점으로 옮김
            list.add(arr);
        } else { // 원반이 두개 이상일 때는 (재귀 호출시 n-1처럼 규모를 줄여 호출)
            hanoi(n - 1, from, to, temp); // 제일밑원반을 제외한 위쪽원반들은 임시막대로 옮기고(재귀적으로)
            int[] arr = {from, to}; // 제일밑원반을 목표지점으로 옮기고
            list.add(arr);
            hanoi(n - 1, temp, from, to); // 위쪽원반들을 임시막대에서 최종목표로 옮김(재귀적으로)
        }
    }

    public static void main(String[] args) {
        HanoiTower h = new HanoiTower();
        System.out.print(Arrays.deepToString(h.solution(3)));
    }
}
