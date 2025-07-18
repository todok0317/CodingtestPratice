package codingtest.programmers;

import java.util.Stack;

public class PairRemoval {

    public int solution(String s) {
        // Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the stack is empty, push the current character
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                // If the top character is the same as current, pop it
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    // If not same, push current character
                    stack.push(ch);
                }
            }
        }

        // Return 1 if stack is empty (all pairs removed), otherwise 0
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        PairRemoval pr = new PairRemoval();

        // Test examples
        String test1 = "baabaa";  // Expected: 1
        String test2 = "cdcd";    // Expected: 0

        System.out.println("Result for \"" + test1 + "\": " + pr.solution(test1));
        System.out.println("Result for \"" + test2 + "\": " + pr.solution(test2));
    }
}

