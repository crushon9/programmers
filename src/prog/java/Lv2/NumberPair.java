package prog.java.Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class NumberPair {
    public static String solution(String X, String Y) {
        String answer = "";
        Integer[] XnumCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Integer[] YnumCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] numPrint = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Integer[] numCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // 숫자 별로 몇개인지 배열에 갯수를 담고
        for (int i = 0; i < X.length(); i++) {
            XnumCnt[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            YnumCnt[Y.charAt(i) - '0']++;
        }
        // 둘 중 갯수가 작은 값을 결과 배열에 담기
        for (int i = 0; i < 10; i++) {
            numCnt[i] = XnumCnt[i] > YnumCnt[i] ? YnumCnt[i] : XnumCnt[i];
        }

        // 큰숫자부터 갯수만큼 answer에 담기
        int zeroFalg = 0;
        for (int i = numCnt.length - 1; i >= 0; i--) {
            for (int cnt = 0; cnt < numCnt[i]; cnt++) {
                answer += numPrint[i];
                if (i != 0) {
                    zeroFalg = 1;
                }
            }
        }

        if (answer == "") {
            answer = "-1"; // 일치하는 숫자가 없을땐 -1
        } else {
            if (zeroFalg == 0) {
                answer = "0"; // 일치하는 숫자가 전부 0일때는 0
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String x = "1100";
        String y = "1123450";

        System.out.println(solution(x, y));
    }

/* 시간초과 로직
      public String solution(String X, String Y) {
        String answer = "";
        // ArrayList에 옮겨 담기
        ArrayList<Integer> YArr = new ArrayList<>();
        for (int yi = 0; yi < Y.length(); yi++) {
            YArr.add(Y.charAt(yi) - '0');
        }

        // 일치하는 값만 골라내기
        ArrayList<Integer> resArr = new ArrayList<>();
        for (int xi = 0; xi < X.length(); xi++) {
            int sameIdx = YArr.indexOf(X.charAt(xi)-'0');
            if (sameIdx != -1) {
                resArr.add(X.charAt(xi)-'0');
                YArr.remove(sameIdx);
            }
        }

        if (resArr.size() == 0) {
            answer = "-1"; // 일치하는 숫자가 없을땐 -1
        } else {
            resArr.sort((Comparator.reverseOrder()));
            int zeroFalg = 0;
            for (int a : resArr) {
                if (a != 0) {
                    zeroFalg = 1;
                }
                answer += Integer.toString(a);
            }
            if (zeroFalg == 0) {
                answer = "0"; // 일치하는 숫자가 전부 0일때는 0
            }
        }
        return answer;
    }*/
}
