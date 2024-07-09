import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        // X와 Y에서 숫자 빈도를 계산합니다.
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder answer = new StringBuilder();
        boolean hasNonZero = false;

        // 9부터 0까지 숫자를 확인하여 공통된 숫자를 추가합니다.
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(countX[i], countY[i]);
            if (count > 0 && i != 0) {
                hasNonZero = true;
            }
            for (int j = 0; j < count; j++) {
                answer.append(i);
            }
        }

        // 결과 문자열이 비어있는 경우와 0으로만 구성된 경우를 처리합니다.
        if (answer.length() == 0) {
            return "-1";
        }
        if (!hasNonZero) {
            return "0";
        }
        return answer.toString();
    }
}
