package codeChallenge;

public class LackMoney {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
    public static long solution(int price, int money, int count) {
        long answer = 0;
        long need = 0;

        for (int i = 1; i <= count; i++) {
            need += (i * price);
        }

        if (need > money) {
            answer = need - money;
        } else {
            answer = 0;
        }
        return answer;
    }
}
