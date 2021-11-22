package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BestAlbum {
    public static void main(String[] args) {
        int SIZE = 5;
        String[] genres = new String[SIZE];
        int[] plays = new int[SIZE];

        genres[0] = "classic";
        genres[1] = "pop";
        genres[2] = "classic";
        genres[3] = "classic";
        genres[4] = "pop";

        plays[0] = 500;
        plays[1] = 600;
        plays[2] = 150;
        plays[3] = 800;
        plays[4] = 2500;

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> keySet = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySet, ((o1, o2) -> hashMap.get(o2).compareTo(hashMap.get(o1)))); // 내림차순으로 정렬 -> ["pop", "classic"]


        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < keySet.size(); i++) {
            int firstIndex = 0; // 장르 중 가장 많이 재생된 해당 인덱스 번호
            int secondIndex = -1; // 장르 중 두번째로 많이 재생된 인덱스 번호
            int maxCount = 0; // 최고 재생 횟수

            String genreName = keySet.get(i); // pop or classic

            for (int j = 0; j < genres.length; j++) {
                if (genreName.equals(genres[j]) && plays[j] > maxCount) {
                    maxCount = plays[j];
                    firstIndex = j;
                }
            }
            resultList.add(firstIndex);
            maxCount = -1;

            for (int j = 0; j < genres.length; j++) {
                if (genreName.equals(genres[j])) {
                    if (plays[j] > maxCount && j != firstIndex) {
                        maxCount = plays[j];
                        secondIndex = j;
                    }
                }
            }
            if (secondIndex >= 0)
                resultList.add(secondIndex);
        }
        answer = resultList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
