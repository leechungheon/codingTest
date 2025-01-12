class Solution {
    public int solution(int m, int n, String[] board) {
        //입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
        int answer = 0;
        char[][] splitBoard = new char[m][n];

//        //초기 배열 설정
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                splitBoard[i][j] = '0'; // 문자 '0'으로 초기화
//            }
//        }
        for(int i=0; i<board.length; i++){
            splitBoard[i]=board[i].toCharArray();
        }

        while(true) {
            boolean[][] checkBoard = new boolean[m][n];
            boolean fountMatch = false;
            //기준점 기준 2x2 찾기
            for (int i = 0; i <= m - 2; i++) {
                for (int j = 0; j <= n - 2; j++) {
                    if (findDeletePoint(splitBoard, i, j)) {
                        checkBoard[i][j] = true;
                        checkBoard[i+1][j] = true;
                        checkBoard[i][j+1] = true;
                        checkBoard[i+1][j+1] = true;
                        fountMatch=true;
                    }
                }
            }
            if(!fountMatch)break;
            //지우기
            for (int i = 0; i <m; i++) {
                for (int j = 0; j<n; j++) {
                    if (checkBoard[i][j]) {
                        splitBoard[i][j]='0';
                        answer++;
                    }
                }
            }
            for (int i = m - 2; i >= 0; i--) { // 위에서 아래로
                for (int j = 0; j < n; j++) {
                    if (splitBoard[i][j] != '0' && splitBoard[i + 1][j] == '0') {
                        downPoint(splitBoard, i, j);
                    }
                }
            }

        }

        return answer;
    }
    private boolean findDeletePoint(char[][] board, int i, int j){
        if(board[i][j]!='0'&&board[i][j]==board[i+1][j] && board[i][j]==board[i][j+1]&&board[i][j]==board[i+1][j+1]){
            return true;
        }else{
            return false;
        }
    }
    private void downPoint(char[][] board, int i, int j) {
        int row = i;
        while (row < board.length - 1 && board[row + 1][j] == '0') {
            board[row + 1][j] = board[row][j];
            board[row][j] = '0';
            row++;
        }
    }
}