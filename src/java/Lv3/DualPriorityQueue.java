package java.Lv3;

import java.util.ArrayList;
import java.util.Collections;

public class DualPriorityQueue {
    class Solution {
        public int[] solution(String[] operations) {
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < operations.length; i++) {
                if (operations[i].charAt(0) == 'I') {
                    list.add(Integer.parseInt(operations[i].split(" ")[1]));
                    Collections.sort(list);
                } else if (operations[i].equals("D 1") && list.size() != 0) {
                    list.remove(list.size() - 1);
                } else if (operations[i].equals("D -1") && list.size() != 0) {
                    list.remove(0);
                }
            }

            int max = 0;
            int min = 0;
            if (list.size() != 0) {
                max = list.get(list.size() - 1);
                min = list.get(0);
            }
            int[] answer = {max, min};
            return answer;
        }
    }
}
