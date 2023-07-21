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
        // answer 에 메세지 넣기
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

/*
["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
        ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

        record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다.
        다음은 record에 담긴 문자열에 대한 설명이다.
        모든 유저는 [유저 아이디]로 구분한다.
        [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
        [유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
        [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
        첫 단어는 Enter, Leave, Change 중 하나이다.
        각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
        유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
        유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
        채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
*/
