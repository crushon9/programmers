package prog.java.Lv2;

import java.util.Arrays;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int b_row = 0;
        int b_col = 0;
        int moseri = 4;
        for (int y_row = yellow; y_row > 0; y_row--) {
            if (brown == moseri + y_row * 2 + (yellow / y_row * 2)) {
                b_row = y_row + 2;
                b_col = (brown + yellow) % b_row == 0 ? (brown + yellow) / b_row : -1;
                if (b_col == -1) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return new int[]{b_row, b_col};
    }

    public static void main(String[] args) {
        Carpet ins = new Carpet();
        System.out.print(Arrays.toString(ins.solution(24, 24)));
    }
}