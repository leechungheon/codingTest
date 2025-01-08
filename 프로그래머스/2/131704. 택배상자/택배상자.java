import java.util.Stack;

class Solution {
    //첫번째로 맞는 상자가 오기 전까지 세컨벨트에 스택으로 저장.
    //기존 상자보다 숫자가 적은 상자가 와야하면 스택에서 pop
    //기존 상자보다 숫자가 커야하면 퍼스트에서 add
    public int solution(int[] order) {
        //입력값 〉	[4, 3, 1, 2, 5]
        //입력값 〉	[5, 4, 3, 2, 1]
        //3,4,1,2,5
        int answer = 0;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=1; i<=order.length; i++){
            if(order[j]==i){//맞는 상자가 왔으면
                answer++;
                j++;
            }else{//맞는 상자가 아니라면
                if(order[j]>i){//더 큰 상자가 와야한다면
                    stack.add(i);
                }else{//더 작은 상자가 와야한다면
                    if(!stack.isEmpty() && stack.peek()==order[j]){
                        stack.pop();
                        answer++;j++;i--;
                    }else{
                        break;
                    }
                }
            }
        }
        // 스택에 남아있는 값 처리
        while (!stack.isEmpty()) {
            if (stack.peek() == order[j]) {
                stack.pop();
                answer++;
                j++;
            } else {
                break;
            }
        }

        return answer;
    }
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] order = {1,2,4,3,5}; // 예시 입력
            int result = solution.solution(order);

            System.out.println("정답: " + result); // 결과 출력
        }
}