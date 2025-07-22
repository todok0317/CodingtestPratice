package codingtest.programmers;

import java.util.Stack;
import java.util.Arrays;

public class NoSameAdjacentNumbers {
    public int[] solution(int[] arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // arr 순회
        for (int i : arr) {
            // 스택이 비어있거나 i가 직전에 담긴 값과 다를 경우 스택에 i 넣기
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        // stack to array
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        NoSameAdjacentNumbers solver = new NoSameAdjacentNumbers();

        int[] input = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solver.solution(input);

        System.out.println("입력: " + Arrays.toString(input));
        System.out.println("출력: " + Arrays.toString(result));
    }
}

