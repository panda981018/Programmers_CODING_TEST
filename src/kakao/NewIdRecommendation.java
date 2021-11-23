package kakao;

public class NewIdRecommendation {
    public static void main(String[] args) {
        String id = "abcdefghijklmn.p";
        System.out.println(recommendation(id));
    }

    public static String recommendation(String new_id) {

        // 1단계 : 소문자로 변환
        String answer = new_id.toLowerCase();
        // 2단계 : a-z, 0-9, -, _, . 제외한 것들은 삭제
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        // 3단계 : .. -> . 로 치환
        answer = answer.replaceAll("[.]{2,}", ".");
        // 4단계 : . 이 처음 또는 끝일 경우 제거
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5단계 : 빈 문자열이라면, new_id.append("a");
        if (answer.length() == 0) {
            answer += "a";
        }
        // 6단계 : 16자 이상이라면, index < 15까지만 남기고 제거. 제거한 뒤에 마침표가 마지막자리라면 . 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        // 7단계 : 2자 이하라면, new_id의 마지막 문자를 3자 이상이 될때까지 반복해서 붙여넣기.
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                char lastChar = answer.charAt(answer.length() - 1);
                answer += lastChar;
            }
        }

        return answer;
    }
}
