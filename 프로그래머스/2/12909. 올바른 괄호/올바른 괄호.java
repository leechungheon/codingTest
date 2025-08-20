import java.util.LinkedList;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        // 스택으로 사용할 Deque 선언
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // 열린 괄호는 스택에 push
                stack.push(ch);
            } else if (ch == ')') {
                // 닫힌 괄호일 경우
                if (stack.isEmpty()) {
                    // 스택이 비어있는데 닫힌 괄호가 나오면 올바르지 않음
                    return false;
                }
                // 스택의 맨 위 요소를 pop
                stack.pop();
            }
        }
        
        // 반복문이 끝난 후 스택이 비어있으면 괄호 짝이 모두 맞음
        return stack.isEmpty();
    }
}