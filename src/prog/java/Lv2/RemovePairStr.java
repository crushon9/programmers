package prog.java.Lv2;

public class RemovePairStr {
    public int solution(String s) {
        String pre = s; // 짝지어 제거하기전 문자열 초기화
        String res = remove(s); // 제거한 후 문자열 초기화

        while (pre.length() != res.length()) { // 제거하기전과 제거한후 문자열의 갯수가 다르면 다시 제거 함수
            pre = res; // 이전의 결과값을 pre에 넣고
            res = remove(res); // 함수의 결과값을 res에 다시 넣기
        }
        int answer = res.length() == 0 ? 1 : 0;
        return answer;
    }

    String remove(String s1) {
        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            if (i < s1.length() - 1 && s1.charAt(i) == s1.charAt(i + 1)) { // 인덱스초과예외 방지, 뒷자리와 같으면
                i++; // 인덱스를 한칸 건너뛰고
                continue;
            } else {
                res += s1.charAt(i); // 아니라면 결과값에 문자를 붙임
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemovePairStr h = new RemovePairStr();
        System.out.print(h.solution("baabaa"));
    }
}
