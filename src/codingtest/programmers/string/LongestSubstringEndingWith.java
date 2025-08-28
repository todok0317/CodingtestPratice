package codingtest.programmers.string;

/**
 * 문제 설명
 * 문자열 myString과 pat가 주어집니다.
 * myString의 부분 문자열 중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성하세요.
 *
 * 제한사항
 * - 5 ≤ myString의 길이 ≤ 20
 * - 1 ≤ pat의 길이 ≤ 5
 * - pat은 반드시 myString의 부분 문자열로 주어집니다.
 * - myString과 pat에 등장하는 알파벳은 대문자와 소문자를 구분합니다.
 *
 * 입출력 예
 * myString    pat    result
 * "AbCdEFG"   "dE"   "AbCdE"
 * "AAAAaaaa"  "a"    "AAAAaaaa"
 */


class LongestSubstringEndingWith {
    public String solution(String myString, String pat) {
        String answer = "";

        // i를 0부터 myString.length()까지 반복한다.
        //
        for (int i = 0; i <myString.length() + 1; i++) {

            // String클래스의 substring(int beginIndex, int endIndex) 메서드는
            // 문자열에서 beginIndex(포함)부터 endIndex(제외)까지 잘라서 새로운 문자열을 반환한다.
            // 즉, myString의 앞에서부터 i개의 문자를 잘라낸 새 문자열을 만들어낸다. (접두사 부분을 추출하는 코드)
            String temp = myString.substring(0, i);
            // 잘라낸 temp가 pat로 끝나면 answer를 temp로 갱신한다.
            if(temp.endsWith(pat)) {
                answer = temp;
            }
        }
        return answer;
    }
}
