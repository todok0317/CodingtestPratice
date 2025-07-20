package codingtest.programmers;

import java.util.Arrays;

public class LifeBoat {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int idx = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();

        // 예제 입력
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int result = lifeBoat.solution(people, limit);
        System.out.println("필요한 구명보트 수: " + result); // 예상 결과: 3
    }
}

