package codeChallenge;

public class MinNum {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = n;
        int min = n;
        while (answer > 0) {
            if (n % answer == 1) {
                min = Math.min(answer, min);
            }
            answer--;
        }
        return min;
    }
}
