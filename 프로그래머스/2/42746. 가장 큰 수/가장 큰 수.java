import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        // 1️⃣ 숫자를 문자열로 변환하여 리스트에 저장
        for (int number : numbers) {
            list.add(Integer.toString(number));
        }

        // 2️⃣ (A + B) vs (B + A) 비교하여 내림차순 정렬
        list.sort((a, b) -> (b + a).compareTo(a + b));

        // 3️⃣ 정렬된 숫자를 이어붙이기
        for (String num : list) {
            answer.append(num);
        }

        // 4️⃣ "000" 같은 경우 "0"으로 변환
        if (answer.toString().matches("^0+$")) return "0";

        return answer.toString();
    }
}
