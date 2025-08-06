package codingtest.programmers;

import java.util.*;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score); // 점수 오름차순 정렬

        // 가장 낮은 점수부터 m개씩 묶어서 계산 (가장 낮은 점수인 score[i - m] * m)
        for (int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        FruitSeller seller = new FruitSeller();

        int k = 3; // 사과의 최대 점수
        int m = 4; // 한 상자에 담기는 사과 수
        int[] score = {1, 2, 3, 1, 2, 3, 1}; // 사과들의 점수

        int result = seller.solution(k, m, score);
        System.out.println(result); // 출력 예시: 8
    }
}

