package kakao;

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};
//        int[] lottos = {45, 4, 35, 20, 3, 9};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};

        System.out.println(winLose(lottos, win_nums)[0] + ", " + winLose(lottos, win_nums)[1]);
    }

    public static int[] winLose(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matches = 0;
        int zero = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            } else {
                for (int win_num : win_nums) {
                    if (lotto == win_num) {
                        matches++;
                        break;
                    }
                }
            }
        }

        answer[0] = Math.min(7-(matches + zero), 6);
        answer[1] = Math.min(7-matches, 6);

        return answer;
    }
}
