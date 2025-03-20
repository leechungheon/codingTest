class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4]; // DP 테이블 생성

        // 첫 번째 행 초기화
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        // DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                // 바로 위 행에서, 현재 열(j)이 아닌 값들 중 최댓값을 찾음
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) { // 같은 열 연속 선택 금지
                        maxPrev = Math.max(maxPrev, dp[i - 1][k]);
                    }
                }
                // 현재 위치의 값 + 위에서 찾은 최댓값을 저장
                dp[i][j] = land[i][j] + maxPrev;
            }
        }

        // 마지막 행에서 최댓값 찾기
        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        return answer;
    }
}
