package prog.java.Lv1;

import java.util.*;

public class SameNumRemove {
    public static int[] solution(int[] arr) {
        int[] temparr = new int[arr.length];

        int tidx = 0;
        for (int x : arr) {
            if (tidx == 0) {
                temparr[tidx] = x;
                tidx++;
            } else {
                if (x != temparr[tidx - 1]) {
                    temparr[tidx] = x;
                    tidx++;
                }
            }
        }

        int[] answer = new int[tidx];
        for(int i = 0; i < answer.length; i++){
            answer[i] = temparr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] res = solution(arr);
        System.out.println(Arrays.toString(res));
    }
}
