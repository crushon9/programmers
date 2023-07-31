package prog.java.Lv2;

public class BinaryMin {
    public static int solution(int n) {
        int answer = 0;

        int lenOfN1 = Integer.bitCount(n);
        int cnt = 1;
        boolean flag = true;
        while (flag) {
            if (lenOfN1 == Integer.bitCount(n + cnt)) {
                answer = n + cnt;
                flag = false;
            } else {
                cnt++;
            }
        }

        return answer;
    }

/*    public static void main(String[] args) {
        System.out.println(solution(15));
    }*/
}

/*
public class BinaryMin {
    public static int solution(int n) {
        int answer = 0;

        int lenOfN1 = removeZero(biCasting(n, ""));
        int cnt = 1;
        boolean flag = true;
        while (flag) {
            if (lenOfN1 == removeZero(biCasting(n + cnt, ""))) {
                answer = n + cnt;
                flag = false;
            } else {
                cnt++;
            }
        }

        return answer;
    }

    public static int removeZero(String s1) {
        int len = s1.length();
        int cnt0 = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == '0') {
                cnt0++;
            }
        }
        return len - cnt0;
    }

    public static String biCasting(int num, String str) {
        str = (num % 2) + str;
        if (num / 2 > 0) {
            return biCasting(num / 2, str);
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}*/
