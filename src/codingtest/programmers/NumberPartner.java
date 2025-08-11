package codingtest.programmers;

public class NumberPartner {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        countNumInArr(X, arrX);
        countNumInArr(Y, arrY);

        for (int i = arrX.length - 1; i >= 0; i--) {
            while (arrX[i] >= 1 && arrY[i] >= 1) {
                arrX[i]--;
                arrY[i]--;
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer.toString();
        }
    }

    private void countNumInArr(String str, int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - '0';
            arr[idx]++;
        }
    }

    public static void main(String[] args) {
        NumberPartner solver = new NumberPartner();

        String X = "100";
        String Y = "2345";
        System.out.println(solver.solution(X, Y)); // -1

        X = "100";
        Y = "203045";
        System.out.println(solver.solution(X, Y)); // 0

        X = "100";
        Y = "123450";
        System.out.println(solver.solution(X, Y)); // 10

        X = "5525";
        Y = "1255";
        System.out.println(solver.solution(X, Y)); // 552
    }
}

