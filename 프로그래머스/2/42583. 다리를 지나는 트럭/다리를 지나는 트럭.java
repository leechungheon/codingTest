import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //1.트럭이 더 올라갈 수 있는가 && 빠져나갈 트럭이 있는가
        //2.시간 카운트
        int answer = 0;

        Queue<int[]> beforeBridge= new LinkedList<>(); // 다리를 건너기전 트럭 큐
        Queue<int[]> onBridge=new LinkedList<>(); // 다리를 건너는 트럭 큐

        for(int i=0; i<truck_weights.length; i++){
            int[] onBridgeArr=new int[2]; //트럭 무게 & 트럭 다리위 누적시간
            onBridgeArr[0]=truck_weights[i];
            beforeBridge.add(onBridgeArr);
        }

        while(!beforeBridge.isEmpty() || !onBridge.isEmpty()){
            if(!beforeBridge.isEmpty() && weightCheck(onBridge, beforeBridge.peek())>weight){//무게 초과
                int a=onBridge.size();
                timeCheck(onBridge,bridge_length);
                int b=onBridge.size();
                if(a!=b && weightCheck(onBridge, beforeBridge.peek())<=weight){
                    int[] ext=beforeBridge.poll();
                    ext[1]=1;
                    onBridge.add(ext);
                }

            }else{
                if (!beforeBridge.isEmpty()) { // 추가: beforeBridge가 비어있지 않은 경우에만 poll()
                    onBridge.add(beforeBridge.poll());
                }
                timeCheck(onBridge,bridge_length);
            }
            ++answer;
        }

        return answer;
    }
    public int weightCheck(Queue<int[]> onBridge, int[] nextTruck){ // 다음 트럭 넘어오면 무게 초과인지 확인
        int weight=0;
        Queue<int[]> copyQueue=new LinkedList<>(onBridge);
        while(!copyQueue.isEmpty()){
            int[] num=copyQueue.poll();
            weight+=num[0];
        }
        return (nextTruck != null) ? weight + nextTruck[0] : weight; // nextTruck이 null이면 그냥 현재 무게만 반환
    }
    public void timeCheck(Queue<int[]> onBridge, int bridge_length) {
        int size = onBridge.size();

        for (int i = 0; i < size; i++) {
            int[] truck = onBridge.poll();
            truck[1]++; // 트럭의 다리 위에서 경과한 시간 증가
            onBridge.add(truck); // 다시 큐에 추가
        }

        // 다리를 다 건넌 트럭 제거
        if (!onBridge.isEmpty() && onBridge.peek()[1] > bridge_length) {
            onBridge.poll();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int result = solution.solution(bridge_length, weight, truck_weights);
        System.out.println("출력값: " + result); // 예상 결과: 8
    }
}