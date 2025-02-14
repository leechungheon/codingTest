class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int toRemove = k;  // 제거해야 할 숫자의 개수
        for (int i = 0; i < number.length(); i++) {
            // 현재 숫자보다 작은 숫자가 스택의 끝에 있으면 제거
            while (toRemove > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < number.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1); // 마지막 문자 제거
                toRemove--;  // 제거할 숫자 하나 감소
            }
            sb.append(number.charAt(i));  // 현재 숫자 추가
        }

        // k개의 숫자를 제거하지 못했다면 뒤에서부터 제거
        while (toRemove > 0) {
            sb.deleteCharAt(sb.length() - 1);
            toRemove--;
        }

        return sb.toString();  // 최종 문자열 반환
    }
}
