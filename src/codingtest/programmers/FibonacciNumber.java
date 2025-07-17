package codingtest.programmers;

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        int n = 10; // 원하는 값을 넣으세요
        int result = fn.solution(n);
        System.out.println("Fibonacci(" + n + ") % 1234567 = " + result);
    }

    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }

    public int fibo(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 큰 수 처리를 위해 1234567로 나눈 나머지를 저장
            cache[i] = (cache[i - 1] + cache[i - 2]) % 1234567;
        }

        return cache[n];
    }
}

