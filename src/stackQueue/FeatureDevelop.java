package stackQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열 progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
 * 배열 speeds : 각 작업의 개발 속도가 적힌 정수 배열
 * 각 배포(하루에 한번, 하루의 끝에 이루어짐)마다 몇 개의 기능이 배포 되는지 배열로 리턴
 */
public class FeatureDevelop {
    public static void main(String[] args) {
        int[] progresses = {99, 80, 82, 50};
        int[] speeds = {3, 5, 3, 5};

        int[] result = deploy(progresses, speeds);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static int[] deploy(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> deploySchedule = new ArrayList<>();
        int[] needs = new int[progresses.length]; // 각 작업의 소요일

        for(int i = 0; i < progresses.length; i++) {
            int leftOver = 100 - progresses[i];

            if (leftOver < speeds[i]) {
                needs[i] = 1;
            } else if (leftOver % speeds[i] != 0) {
                needs[i] = leftOver / speeds[i] + 1;
            } else {
                needs[i] = leftOver / speeds[i];
            }
        }

        int count = 1; // 하루에 배포할 작업의 수
        for (int j = 0; j < needs.length; j++) {
            if (j+1 == needs.length) {
                deploySchedule.add(count);
                break;
            } else if (needs[j] >= needs[j + 1]) {
                count++;
            } else {
                deploySchedule.add(count);
                count = 1;
            }
        }

        answer = new int[deploySchedule.size()];
        for (int i = 0; i < deploySchedule.size(); i++) {
            answer[i] = deploySchedule.get(i);
        }

        return answer;
    }
}
