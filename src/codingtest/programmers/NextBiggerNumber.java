package codingtest.programmers;

public class NextBiggerNumber {
    public static void main(String[] args) {
        int input = 78;
        int result = findNextNumberWithSameBinaryOnes(input);
        System.out.println("Next bigger number with same number of 1s: " + result);
    }

    public static int findNextNumberWithSameBinaryOnes(int n) {
        int targetOneCount = countBinaryOnes(n);

        while (true) {
            n++;
            if (countBinaryOnes(n) == targetOneCount) {
                return n;
            }
        }
    }

    // Counts the number of 1s in the binary representation of a number
    private static int countBinaryOnes(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}

