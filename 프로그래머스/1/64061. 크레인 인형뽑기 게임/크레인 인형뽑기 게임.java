import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stack=new Stack[board.length];
        Stack<Integer> bucket=new Stack();

        // 스택 배열을 초기화합니다.
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Stack<>();
        }

        for(int i=0; i<board.length; i++){
            for(int j=board.length-1; j>=0; j--){
                if(board[j][i]!=0)stack[i].push(board[j][i]);
            }
        }

        for(int i=0; i<moves.length; i++){
            int n=-1;
            if(!bucket.isEmpty()){
                n= bucket.peek();
            }
            if(!stack[moves[i]-1].isEmpty() && n==stack[moves[i]-1].peek()){
                bucket.push(stack[moves[i]-1].peek());
                stack[moves[i]-1].pop();
                bucket.pop();
                bucket.pop();
                answer+=2;
            }else if(!stack[moves[i]-1].isEmpty()){
                bucket.push(stack[moves[i]-1].peek());
                stack[moves[i]-1].pop();
            }

        }
        return answer;
    }
}