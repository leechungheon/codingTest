class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        int maxSide = 0;

        int[][] dp = new int[row][column];

        // board의 첫 번째 행, 첫 번째 열을 그대로 복사
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int j = 0; j < column; j++) {
            dp[0][j] = board[0][j];
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        // DP 테이블 채우기
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]); // 최댓값 갱신
                }
            }
        }

        return maxSide * maxSide; // 넓이 반환
    }
}