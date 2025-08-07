package codingtest.programmers;

public class KnightWeapon {

    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        KnightWeapon solver = new KnightWeapon();

        int number = 10;
        int limit = 3;
        int power = 2;

        int result = solver.solution(number, limit, power);
        System.out.println("Result: " + result);  // 예시 출력: 21
    }
}
