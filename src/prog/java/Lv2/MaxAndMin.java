package prog.java.Lv2;

import java.util.ArrayList;
import java.util.Collections;

class MaxAndMin {
    public String solution(String s) {

        String[] split = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        String answer = Collections.min(list) + " " + Collections.max(list);
        return answer;
    }
}