package codingtest.programmers;

import java.util.*;

public class BinaryConversion {

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int turnCnt = 0; // 이진 변환 횟수
        int zeroCnt = 0; // 삭제한 0의 개수

        String str = s; // 현재 문자열 저장할 변수
        while (true) {
            if (str.equals("1")) break;

            turnCnt++; // 이진 변환 횟수 + 1
            int oneCnt = 0; // "1" 개수

            for (char c : str.toCharArray()) {
                if (c == '1') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }

            str = Integer.toBinaryString(oneCnt);
        }

        answer[0] = turnCnt;
        answer[1] = zeroCnt;
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 s를 입력하세요: ");
        String input = scanner.nextLine();

        int[] result = solution(input);
        System.out.println("이진 변환 횟수: " + result[0]);
        System.out.println("제거된 0의 개수: " + result[1]);
    }
}

