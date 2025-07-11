package codingtest.programmers;

public class JadenCaseConverter {
    public String solution(String s) {
        String answer = "";

        // " " 기준으로 문자열 자르되, 연속 공백 보존
        String[] arr = s.split(" ", -1);

        for (String word : arr) {
            if (word.length() == 0) {
                answer += " ";
            } else {
                // 첫 글자 대문자, 나머지 소문자
                answer += word.substring(0, 1).toUpperCase();
                answer += word.substring(1).toLowerCase();
                answer += " ";
            }
        }

        // 원본 문자열이 공백으로 끝났다면 그대로 반환
        if (s.endsWith(" ")) {
            return answer;
        }

        // 마지막 공백 제거 후 반환
        return answer.substring(0, answer.length() - 1);
    }

    public static void main(String[] args) {
        JadenCaseConverter converter = new JadenCaseConverter();

        System.out.println(converter.solution("3people unFollowed me")); // "3people Unfollowed Me"
        System.out.println(converter.solution("for the last week "));    // "For The Last Week "
        System.out.println(converter.solution(" hello  world  "));       // " Hello  World  "
    }
}

