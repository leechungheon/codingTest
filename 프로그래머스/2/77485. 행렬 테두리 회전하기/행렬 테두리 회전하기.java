class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board=new int[rows][columns];
        int index=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                board[i][j]=index;
                index++;
            }
        }
        for(int i=0; i<queries.length; i++){
            answer[i]=rotateBoard(board, queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1);
        }
        return answer;
    }
    public int rotateBoard(int[][] board, int x1,int y1, int x2, int y2){
        int temp = board[x1][y1]; // 회전할 첫 번째 값을 저장
        int min = temp;
        // 왼쪽에서 위쪽으로 이동
        for (int i = x1; i < x2; i++) {
            board[i][y1] = board[i + 1][y1];
            min = Math.min(min, board[i][y1]);
        }
        // 아래쪽에서 왼쪽으로 이동
        for (int i = y1; i < y2; i++) {
            board[x2][i] = board[x2][i + 1];
            min = Math.min(min, board[x2][i]);
        }
        // 오른쪽에서 아래쪽으로 이동
        for (int i = x2; i > x1; i--) {
            board[i][y2] = board[i - 1][y2];
            min = Math.min(min, board[i][y2]);
        }
        // 위쪽에서 오른쪽으로 이동
        for (int i = y2; i > y1; i--) {
            board[x1][i] = board[x1][i - 1];
            min = Math.min(min, board[x1][i]);
        }
        board[x1][y1 + 1] = temp; // 처음 저장한 값 넣어주기
        return min;
    }
}