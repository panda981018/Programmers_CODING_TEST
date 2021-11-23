package codeChallenge;
import java.util.*;

public class AscNumbers {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        for (int i : solution(numbers)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }

        // set -> List -> sort -> int[]
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
