package codingtest.programmers;

public class BracketValidator {

    // 올바른 괄호인지 판별하는 메서드
    public boolean solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }

            // 닫는 괄호가 먼저 나오면 올바르지 않음
            if (count < 0) {
                return false;
            }
        }

        // 모두 짝지어졌다면 count는 0이어야 함
        return count == 0;
    }

    // 메인 메서드: 테스트 케이스 실행
    public static void main(String[] args) {
        BracketValidator bracketValidator = new BracketValidator();

        String[] testCases = {
            "()()",
            "(())()",
            ")()(",
            "(()(",
            "((()))",
            "())(()"
        };

        for (String test : testCases) {
            boolean result = bracketValidator.solution(test);
            System.out.println("입력: \"" + test + "\" → 결과: " + result);
        }
    }

}
