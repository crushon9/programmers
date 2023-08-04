#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* X, const char* Y) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    // char* answer = (char*)malloc(1);

    int XnumCnt[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int YnumCnt[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char numPrint[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int numCnt[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // 숫자 별로 몇개인지 배열에 갯수를 담고
    for (int i = 0; i < strlen(X); i++) {
        XnumCnt[X[i] - '0']++;
    }
    for (int i = 0; i < strlen(Y); i++) {
        YnumCnt[Y[i] - '0']++;
    }
    // 둘 중 갯수가 작은 값을 결과 배열에 담기
    int len = 0; // 총 결과의 글자수
    for (int i = 0; i < 10; i++) {
        numCnt[i] = XnumCnt[i] > YnumCnt[i] ? YnumCnt[i] : XnumCnt[i];
        len = len + numCnt[i];
    }
    char* answer = (char*)malloc(len);

    if (len == 0) {
        answer = "-1"; // 일치하는 숫자가 없을땐 -1
    } else {
        // 큰숫자부터 갯수만큼 answer에 담기
        int zeroFalg = 0;
        int idx = 0;
        for (int i = 9; i >= 0; i--) {
            for (int cnt = 0; cnt < numCnt[i]; cnt++) {
                answer[idx] = numPrint[i];
                idx++;
                if (i != 0) {
                    zeroFalg = 1;
                }
            }
        }
        answer[idx] = 0; // 마지막 글자 다음글자에 null 삽입
        if (zeroFalg == 0) {
            answer = "0"; // 일치하는 숫자가 전부 0일때는 0
        }
    }

    return answer;
}

/* 같은 로직을 자바코드로 했을 땐 시간초과
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

    // 시간초과 로직
    public String solution2(String X, String Y) {
        String answer = "";
        // ArrayList에 옮겨 담기
        ArrayList<Integer> YArr = new ArrayList<>();
        for (int yi = 0; yi < Y.length(); yi++) {
            YArr.add(Y.charAt(yi) - '0');
        }

        // 일치하는 값만 골라내기
        ArrayList<Integer> resArr = new ArrayList<>();
        for (int xi = 0; xi < X.length(); xi++) {
            int sameIdx = YArr.indexOf(X.charAt(xi) - '0');
            if (sameIdx != -1) {
                resArr.add(X.charAt(xi) - '0');
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
    }
}*/
