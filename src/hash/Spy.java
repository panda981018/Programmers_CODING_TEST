package hash;

import java.util.*;

public class Spy {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hash = new HashMap<>(); // key = 의상 종류, value = 해당 종류의 개수
        for (int i = 0; i < clothes.length; i++) { // clothes.length = 3
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1); // 종류에 관한 hash가 이미 있다면 그 값을 가져오고 없다면 기본값 0을 넣고 +1
        }
        // hash = { {"headgear" : 2}, {"eyewear" : 1} }
        // 조합...조합....
        Set<String> keySet = hash.keySet();
        for (String key : keySet) {
            answer *= hash.get(key) + 1;
        }

        return answer-1;
    }
}
