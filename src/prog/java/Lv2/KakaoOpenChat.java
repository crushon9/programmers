package prog.java.Lv2;

import java.util.HashMap;

public class KakaoOpenChat {
    public static String[] solution(String[] record) {
        HashMap<String, String> userInfo = new HashMap<String, String>();
        int ansLn = 0;
        // 유저 아이디에 매칭되는 최종 별명 hashMap에 담기
        for (int i = 0; i < record.length; i++) {
            String[] rcd = record[i].split(" ");
            if (rcd[0].equals("Enter")) {
                // put : 이미 키값이 있을 경우 최신값으로 덮어씀
                userInfo.put(rcd[1], rcd[2]);
                ansLn++;
            } else if (rcd[0].equals("Change")) {
                userInfo.put(rcd[1], rcd[2]);
            } else {
                ansLn++;
            }
        }
        // Enter와 Leave 일때만 메세지를 출력하므로 answer길이 초기화
        String[] answer = new String[ansLn];

        int cnt = ansLn;
        // answer 에 메세지 담기
        for (int i = 0; i < record.length; i++) {
            String[] rcd = record[i].split(" ");
            if (rcd[0].equals("Enter")) {
                answer[ansLn - cnt] = userInfo.get(rcd[1]) + "님이 들어왔습니다.";
                cnt--;
            } else if (rcd[0].equals("Leave")) {
                answer[ansLn - cnt] = userInfo.get(rcd[1]) + "님이 나갔습니다.";
                cnt--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        for (String x : solution(record)) {
            System.out.println(x);
        }
    }
}
