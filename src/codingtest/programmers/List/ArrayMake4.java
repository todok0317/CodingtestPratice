package codingtest.programmers.List;

import java.util.ArrayList;
/**
 * 문제 설명:
 * 정수 배열 arr가 주어집니다.
 * arr를 이용해 새로운 배열 stk를 만들려고 합니다.
 *
 * 규칙:
 * 1. 변수 i를 0으로 초기화하고, i < arr.length이면 반복합니다.
 * 2. stk가 빈 배열이면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
 * 3. stk에 원소가 있고, stk의 마지막 원소 < arr[i]이면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
 * 4. stk에 원소가 있고, stk의 마지막 원소 >= arr[i]이면 stk의 마지막 원소를 제거합니다.
 * 5. 위 과정을 반복한 후 만들어진 stk를 반환합니다.
 *
 * 제한사항:
 * 1 ≤ arr.length ≤ 100,000
 * 1 ≤ arr의 원소 ≤ 100,000
 *
 * 입출력 예:
 * arr = [1, 4, 2, 5, 3] → result = [1, 2, 3]
 */
class ArrayMake4 {
    public int[] solution(int[] arr) {

        // 동적 배열 tmp : 스택 역할
        ArrayList<Integer> tmp = new ArrayList<>();

        int i = 0;
        while (i < arr.length) {
            // tmp가 비어 있으면 바로 추가
            if(tmp.size() == 0) {
                tmp.add(arr[i]);
                i = i + 1;
            } else {
                // tmp 마지막 원소 확인
                int last = tmp.get(tmp.size() - 1);
                if(tmp.size() != 0 && last<arr[i]) {
                    // 마지막 원소보다 현재 arr[i]가 크면 추가
                    tmp.add(arr[i]);
                    i = i + 1;
                } else if (tmp.size() != 0 && last >= arr[i]) {
                    // 마지막 원소 >= arr[i]이면 마지막 원소 제거
                    tmp.remove(tmp.size() - 1);
                    // i는 증가하지 않음 -> 다시 비교
                }
            }
        }
        // ArrayList -> int[] 변환
        int stk[] = new int[tmp.size()];
        for(int k =0; k<tmp.size(); k++) {
            stk[k] = tmp.get(k);
        }
        return stk;
    }
}
