package codingtest.programmers.List;

import java.util.*;

/**
 * 문제 설명:
 * 정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
 * intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다.
 * 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
 *
 * 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여
 * 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.
 *
 * 입출력 예:
 * arr = [1, 2, 3, 4, 5], intervals = [[1, 3], [0, 4]]
 * 결과 = [2, 3, 4, 1, 2, 3, 4, 5]
 */

class ArrayMake3 {
    public int[] solution(int[] arr, int[][] intervals) {

        // 조건에 맞는 값을 임시로 담기 위한 리스트
        List<Integer> answer = new ArrayList<>();

        // intervals 배열의 각 구간을 순회
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer.add(arr[j]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
