package codeChallenge;

import java.util.*;

public class Measure {
    /**
     * 약수의 개수가 짝수인 수는 더하고,
     * 약수의 개수가 홀수인 수는 뺀 수를 리턴
     * 예) left = 24, right = 27
     * 24 => 8개(짝), 25=>3개(짝), 26 => 4개(짝), 27 => 4개(짝)
     * 24 - 25 + 26 + 27
     */
    public static void main(String[] args) {
        int left = 24;
        int right = 27;

        System.out.println(plusMinus(left, right));
    }

    public static int plusMinus(int left, int right) {
        int answer = 0;
        List<Integer> evenList = new ArrayList<>(); // 짝수
        List<Integer> oddList = new ArrayList<>(); // 홀수

        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
        }

        for (int i = 0; i < evenList.size(); i++) {
            answer += evenList.get(i);
        }
        for (int i = 0; i < oddList.size(); i++) {
            answer -= oddList.get(i);
        }

        return answer;
    }
}
