package codingtest.programmers.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 설명:
 * 정수 l과 r이 매개변수로 주어집니다.
 * l 이상 r 이하의 정수 중에서
 * 숫자가 '0'과 '5'로만 이루어진 수들을 오름차순으로 담은 배열을 반환하세요.
 * 만약 그러한 수가 없다면 [-1]을 반환합니다.
 *
 * 입출력 예:
 * l = 5, r = 555 → [5, 50, 55, 500, 505, 550, 555]
 * l = 10, r = 20 → [-1]
 */

class ArrayMake2 {
    public int[] solution(int l, int r) {

        // 조건에 맞는 값을 담기 위해 List 사용 (크기를 미리 알 수 없으니까)
        List<Integer> list = new ArrayList<>();

        // l부터 r까지 모든 수를 확인
        for (int i = l; i <= r; i++) {
            // 숫자를 문자열로 변환 후 정규식으로 검사
            // "[05]+" -> 0 또는 5만 여러 번 등장하는 문자열만 통과
            // String.valueOf(i)는 정수 i를 문자열로 바꿔준다.
            // Integer.toString(i)랑 똑같다.
            // .matches("[05]+")는 문자열이 정규식에 완전히 일치하는지 검사한다.
            // "[05]+"는 정규식인데 []는 문자 집합 - 대괄호 안의 문자들 중 하나를 의미
            // 05 : 문자 0 또는 5
            // + : 1번 이상 반복
            // 즉, 0과 5로만 이루어진 문자열(길이 1 이상)만 통과
            if (String.valueOf(i).matches("[05]+")){
                list.add(i); // 조건에 맞으면 리스트에 추가
            }
        }
        // 만약 조건에 맞는 수가 하나도 없으면 [-1] 반환
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        // List<Integer> -> int[] 변환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
