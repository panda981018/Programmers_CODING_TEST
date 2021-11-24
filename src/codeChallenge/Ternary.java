package codeChallenge;

public class Ternary {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    /**
     *
     * @param numbers 10진수
     * @return numbers를 뒤집고 10진수로 리턴
     */
    public static int solution(int numbers) {
        String answer = "";
        while (numbers / 3 > 0) {
            answer += numbers % 3;
            numbers /= 3;
        }
        answer += numbers;

        return Integer.parseInt(answer, 3);
    }
}