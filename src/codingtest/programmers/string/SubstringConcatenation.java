package codingtest.programmers.string;

/**
 * 문제 설명
 * 길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다.
 * parts[i]는 [s, e] 형태로, my_strings[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다.
 * 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ my_strings의 길이 = parts의 길이 ≤ 100
 * 1 ≤ my_strings의 원소의 길이 ≤ 100
 * parts[i]를 [s, e]라 할 때, 다음을 만족합니다.
 * 0 ≤ s ≤ e < my_strings[i]의 길이
 *
 * 입출력 예
 * my_strings = ["progressive", "hamburger", "hammer", "ahocorasick"]
 * parts     = [[0, 4], [1, 2], [3, 5], [7, 7]]
 * result    = "programmers"
 */

class SubstringConcatenation {
    public String solution(String[] my_string, int[][] parts) {
        String answer = "";

        for (int i = 0; i < my_string.length; i++) {
            // String.substring(beginIndex, endIndex)는 beginIndex 포함, endIndex 미포함이다.
            // 띠라서 parts[i]의 끝 인덱스 end를 포함하려면 end + 1을 넣어야 정상적인 구간이 나옴.
            answer += my_string[i].substring(parts[i][0], parts[i][1] + 1);
        }

        return answer;
    }

    public String solution2(String[] my_string, int[][] parts) {
        // 문자열을 효율적으로 이어 붙이거나 수정할 때 사용하는 클래스이다.
        // 자바의 문자열은 불변 -> 한번 생성하면 값이 바뀌지 않음.
        // StringBuilder는 가변 문자열 -> 내부적으로 char[] 버퍼를 가지고 있어서 문자열을 수정할 수 있다.
        // append(String s) : 문자열을 뒤에 붙임
        // insert(int index, String s) : 특정 위치에 문자열 삽입
        // delete(int start, int end) : 문자열 삭제
        // reverse() : 문자열 뒤집기
        // toString() : 최종적으로 일반 String으로 변환
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < my_string.length; i++) {
            stringBuilder.append(my_string[i].substring(parts[i][0], parts[i][1] + 1));
        }

        return stringBuilder.toString();
    }
}
