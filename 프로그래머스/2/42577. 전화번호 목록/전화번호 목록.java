import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호부를 사전식으로 오름차순 정렬
        Arrays.sort(phone_book);

        // 정렬된 배열을 순회하며 바로 다음 번호와 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 번호(phone_book[i])가 바로 다음 번호(phone_book[i+1])의 접두어인지 확인
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false; // 접두어가 있으면 즉시 false 반환
            }
        }
        return true; // 전체를 다 확인해도 접두어가 없으면 true 반환
    }
}