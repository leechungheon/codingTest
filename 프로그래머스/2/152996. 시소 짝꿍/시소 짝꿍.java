import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for (int i = 0; i < weights.length - 1; i++) {
            // weights[i]와 같은 무게를 가진 사람들의 수를 셉니다.
            int count = 1;
            while (i < weights.length - 1 && weights[i] == weights[i + 1]) {
                count++;
                i++;
            }

            // Case 1: 무게가 같은 사람들의 쌍을 계산합니다.
            // n명이 동일한 무게를 가질 때, 만들 수 있는 쌍의 수는 n * (n - 1) / 2 입니다.
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }

            // Case 2: weights[i]와 다른 무게를 가진 사람들의 쌍을 계산합니다.
            // 남은 사람들 중에서 weights[i]의 비율에 맞는 사람들을 찾습니다.
            for (int j = i + 1; j < weights.length; j++) {
                // weights[i] * 2 < weights[j]인 경우, weights[j]가 너무 커서
                // 이후의 어떤 weights[j']와도 조건을 만족하지 못하므로 루프를 종료합니다.
                if (weights[i] * 2 < weights[j]) {
                    break;
                }

                if (weights[i] * 3 == weights[j] * 2) {
                    answer += count;
                }
                if (weights[i] * 4 == weights[j] * 2) {
                    answer += count;
                }
                if (weights[i] * 4 == weights[j] * 3) {
                    answer += count;
                }
            }
        }
        return answer;
    }
}