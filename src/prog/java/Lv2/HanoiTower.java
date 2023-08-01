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
            System.out.println(Arrays.toString(x));
        }

        return answer;
    }

    public void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            int[] arr = {from, to};
            list.add(arr);
        } else {
            hanoi(n - 1, from, to, temp);
            int[] arr = {from, to};
            list.add(arr);
            hanoi(n - 1, temp, from, to);
        }
    }

    public static void main(String[] args) {
        HanoiTower h = new HanoiTower();
        h.solution(4);
    }
}
