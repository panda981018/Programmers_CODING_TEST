package string;

public class compressString {
    public static void main(String[] args) {
        String str = "xababcdcdababcdcd";
        int min = str.length();
        for (int i = 1; i <= str.length(); i++) {
            int answer = compression(str, i).length();
            min = Math.min(min, answer);
        }

        System.out.println("최소 길이 : " + min);
    }

    public static String compression(String str, int i) {
        int count = 1;
        String compression = ""; // 압축된 문자열
        String pattern = ""; // i만큼 자른 패턴

        for (int j = 0; j <= str.length() + i; j += i) {
            String nowStr = "";

            // 패턴과 비교할 현재 문자열을 찾자
            if (j >= str.length()) {
                nowStr = "";
            } else if (j + i > str.length()) {
                nowStr = str.substring(j);
            } else {
                nowStr = str.substring(j, j + i);
            }

            // 패턴과 현재 문자열 비교하기
            // count가 2 이상이면 count + pattern
            // j = 0일 때는 nowStr = pattern
            if (j != 0) {
                if (nowStr.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compression += count + pattern;
                    count = 1;
                } else {
                    compression += pattern;
                }
            }
            pattern = nowStr;
        }

        return compression;
    }
}
