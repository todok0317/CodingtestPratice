package codingtest.programmers;

import java.util.*;

public class MinMaxFinder {
    public String findMinMax(String s) {
        String[] temp = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < temp.length; i++) {
            int num = Integer.parseInt(temp[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        MinMaxFinder finder = new MinMaxFinder();

        // 예제 입력
        String input = "1 2 3 4";
        String result = finder.findMinMax(input);

        // 출력: "1 4"
        System.out.println("입력: " + input);
        System.out.println("출력: " + result);

        // 추가 테스트
        System.out.println("테스트 1: " + finder.findMinMax("-1 -2 -3 -4"));  // "-4 -1"
        System.out.println("테스트 2: " + finder.findMinMax("-1 -1"));       // "-1 -1"
    }
}

