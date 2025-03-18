class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col=arr1.length;
        int row=arr2[0].length;
        int[][] answer = new int[col][row];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}