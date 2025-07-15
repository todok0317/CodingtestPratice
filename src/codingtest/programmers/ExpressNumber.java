package codingtest.programmers;

public class ExpressNumber {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = i; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    answer++;
                    break;
                }

                if (sum > n) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ExpressNumber obj = new ExpressNumber();
        int n = 15;
        int result = obj.solution(n);
        System.out.println("결과: " + result); // 출력: 4
    }
}

