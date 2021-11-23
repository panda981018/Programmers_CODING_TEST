package codeChallenge;

import java.util.Arrays;

public class PlusNum {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,6,7,8,0};
        int[] nums = {5,8,4,0,6,7,9};
        System.out.println(plus(nums));
    }

    public static int plus(int[] numbers) {
        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        return 45 - sum;
    }
}
