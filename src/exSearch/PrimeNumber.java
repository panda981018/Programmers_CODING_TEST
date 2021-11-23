package exSearch;

public class PrimeNumber {
    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;
        String[] numArr = numbers.split("");
        for (int i = 0; i < numArr.length; i++)
            System.out.println(numArr[i]);

        return answer;
    }
}
