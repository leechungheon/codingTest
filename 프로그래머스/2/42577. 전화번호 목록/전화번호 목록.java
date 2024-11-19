import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 0; j < phoneBook[i].length(); j++) {
                if(map.containsKey(phoneBook[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
            public static void main(String[] args) {
            Solution solution = new Solution();

            // 테스트 케이스
            String[] phone_book = {"119", "97674223", "1195524421"};

            // 결과 출력
            boolean result = solution.solution(phone_book);
            System.out.println("결과: " + result); // 예상 출력: false
        }
}
