package kakao;
import java.util.*;

public class Keypad {
    public static void main(String[] args) {

    }

    public static String keypad(int[] numbers, String hand) {
        String answer = "";

        int[] leftHand = { 1, 4, 7 };
        int[] rightHand = { 3, 6, 9 };

        for (int i = 0; i < numbers.length; i++) {
            if (Arrays.asList(leftHand).contains(numbers[i]))
                answer += "L";
            else if (Arrays.asList(rightHand).contains(numbers[i])){
                answer += "R";
            } else {

            }
        }

        return answer;
    }
}
