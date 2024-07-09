class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        if(h>0){
            if(board[h-1][w].equals(board[h][w]))answer++;
        }
        if(h<board[0].length-1){
            if(board[h+1][w].equals(board[h][w]))answer++;
        }
        if(w>0){
            if(board[h][w-1].equals(board[h][w]))answer++;
        }
        if(w<board.length-1){
            if(board[h][w+1].equals(board[h][w]))answer++;
        }
        return answer;
    }
}