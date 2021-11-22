package hash;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        String[] arr = new String[5];

        arr[0] = "12";
        arr[1] = "123";
        arr[2] = "1235";
        arr[3] = "567";
        arr[4] = "88";

        boolean ans = solution(arr);
        System.out.println("answer = " + ans);
    }

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hash.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hash.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
