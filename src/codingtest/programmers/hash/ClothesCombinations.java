package codingtest.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClothesCombinations {

    /**
     * 의상 조합의 가능한 경우의 수를 계산하는 함수
     *
     * @param clothes 의상 목록. 각 의상은 이름과 종류로 구성됨.
     * @return 가능한 의상 조합의 수
     * https://school.programmers.co.kr/learn/courses/30/lessons/42578
     */
    public int solution(String[][] clothes) {
        // 의상 종류별로 옷의 개수를 저장하는 map
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류별로 옷의 개수를 세는 과정
        for (String[] clothe : clothes) {
            // clothe[0]은 옷의 이름, clothe[1]은 옷의 종류
            // map에 해당 의상 종류의 개수를 1씩 증가시킴
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        // map을 순회할 Iterator 생성
        Iterator<Integer> it = map.values().iterator();

        // 의상 종류별로 선택 가능한 경우의 수 계산
        while (it.hasNext()) {
            // 각 의상 종류의 개수에 대해 +1을 해주어 의상을 입지 않는 경우도 포함
            answer *= it.next() + 1;
        }

        // "아무것도 입지 않는 경우"를 제외하기 위해 -1을 해줌
        return answer - 1;
    }

    //완료
}
