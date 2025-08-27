package codingtest.programmers.List;

// 문제 설명:
// 정수 n과 k가 주어졌을 때,
// 1 이상 n 이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 반환하는 문제.
//
// 예시:
// n = 10, k = 3  → [3, 6, 9]
// n = 15, k = 5 → [5, 10, 15]


class ArrayMake1 {
    public int[] solution(int n, int k) {

        // n까지의 수 중 k의 배수 개수는 (n / k)개
        // 예) n=10, k=3 → 3, 6, 9 → 총 3개 → 10/3 = 3
        int[] answer = new int[n/k];

        // 배열에 값을 채워넣기 위한 인덱스 변수
        int idx = 0;

        // 1부터 n까지 반복하면서
        for (int i = 1; i <= n; i++) {
            // i가 k의 배수라면 배열에 추가
            if (i % k == 0) {
                answer[idx++] = i; // answer[0] = k, answer[1] = 2k, ...
            }
        }
        // 완성된 배열 반환
        return answer;
    }

}
