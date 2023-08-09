package prog.java.Lv2;

import java.util.Arrays;

public class WordChainGame {

    public int[] solution(int n, String[] words) {

        int fail = 0;
        for (int i = 1; i < words.length; i++) { // 두번째 단어부터 검사
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) // 이전단어의 제일마지막글자와 현재단어의 제일첫글자가 같지않거나
                    || Arrays.asList(words).indexOf(words[i]) < i) { // 현재글자의 indexOf 결과값이 현재 인덱스보다 작다면 즉, 이전에 등장한적있는 글자라면
                fail = i + 1; // 현재 인덱스에 1을 더해서(1부터 시작하는 차례) 담음
                break;
            }
        }
        int who = 0, seq = 0; // fail 아닐때는 0,0으로 초기화
        if (fail != 0) { // fail 했을때만
            who = fail % n == 0 ? n : fail % n; // fail차례를 인원으로 나눈 나머지로 몇번째 사람이었는지 계산
            seq = fail / n + (who == n ? 0 : 1); // 그 사람의 몇번째 차례였는지
        }

        return new int[]{who, seq};
    }

    public static void main(String[] args) {
        WordChainGame h = new WordChainGame();

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.print(Arrays.toString(h.solution(n, words)));
    }
}
