package codingtest.programmers;

public class SecretCode {
    public static void main(String[] args) {
        SecretCode solution = new SecretCode();

        // 테스트 케이스 예시
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String result = solution.secretBetweenUs(s, skip, index);
        System.out.println("암호화된 문자열: " + result);  // 결과 예시 출력
    }

    public String secretBetweenUs(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                if (ch == 'z') {
                    ch = 'a';
                } else {
                    ch++;
                }

                if (!skip.contains(String.valueOf(ch))) {
                    count++;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
