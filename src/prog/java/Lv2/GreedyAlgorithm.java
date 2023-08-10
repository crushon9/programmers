package prog.java.Lv2;

import java.util.Arrays;

public class GreedyAlgorithm {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); // 크기순서로 정렬
        int endIdx = people.length - 1;
        int starIdx = 0;
        while (starIdx <= endIdx) {
            if (starIdx == endIdx) {
                answer++;
                break;
            }
            if (people[starIdx] + people[endIdx] <= limit) {
                answer++;
                endIdx--;
                starIdx++;
            } else {
                answer++;
                endIdx--;
            }
        }

        return answer;
    }

/*    public static void main(String[] args) {
        GreedyAlgorithm h = new GreedyAlgorithm();

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.print(h.solution(people, limit));
    }*/

/*    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) { // 무거운 사람을 기준점으로 한칸씩 앞으로 가는데
            if (people[i] + people[j] <= limit) // 가벼운 사람이 같이 탈수있으면
                ++i; // 다음 가벼운 사람을 검사
        }
        return people.length - i; // 전체 인원수 중에 같이 타는 조건을 만족한 가벼운 사람 만큼 빼줌
    }*/
}
