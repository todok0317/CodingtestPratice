package codingtest.programmers;

import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> point = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            point.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            String[] person = photo[i];
            int score = 0;

            for (int j = 0; j < person.length; j++) {
                String personName = person[j];
                if (point.containsKey(personName)) {
                    score += point.get(personName);
                }
            }
            answer[i] = score;
        }
        return answer;
    }

    public static void main(String[] args) {
        MemoryScore solver = new MemoryScore();

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };

        int[] result = solver.solution(name, yearning, photo);
        for (int r : result) {
            System.out.print(r + " ");
        }
        // 출력 예시: 19 15 6
    }
}

