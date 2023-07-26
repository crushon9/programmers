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

/*
    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }*/
