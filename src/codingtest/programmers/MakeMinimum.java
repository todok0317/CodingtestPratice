package codingtest.programmers;

import java.util.Arrays;

public class MakeMinimum {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // A는 오름차순, B는 오름차순 후 역순으로 접근
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        MakeMinimum solver = new MakeMinimum();

        // 테스트 입력
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        int result = solver.solution(A, B);

        System.out.println("최솟값: " + result); // 출력 예시: 29
    }
}

