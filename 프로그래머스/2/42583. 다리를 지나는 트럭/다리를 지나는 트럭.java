import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //다리 위의 트럭 큐, int truck={트럭 무게, 트럭 이동거리)
        Queue<int[]> bridge = new ArrayDeque<>();

        //대기하고 있는 트럭 큐
        Queue<Integer> waitingTrucks = new ArrayDeque<>();
        for (int truckWeight : truck_weights) {
            waitingTrucks.add(truckWeight);
        }
        int currentWeightOnBridge=0;
        // 모든 트럭이 다리를 건너고 다리 위가 완전히 비워질 때까지 반복
        while (!waitingTrucks.isEmpty() || !bridge.isEmpty()) {
            answer++; // 1초 경과

            // 1. 다리 통과 여부 확인: 맨 앞 트럭이 다리를 완전히 건넜는지 확인
            if (!bridge.isEmpty() && bridge.peek()[1] + bridge_length <= answer) {
                int[] truck = bridge.poll();
                currentWeightOnBridge -= truck[0];
            }

            // 2. 새 트럭 진입 가능성 확인
            if (!waitingTrucks.isEmpty()) {
                int nextTruckWeight = waitingTrucks.peek();
                //무게를 초과하지 않는다면
                if (currentWeightOnBridge + nextTruckWeight <= weight) {
                    // 다리 위 트럭 수 체크
                    if (bridge.size() < bridge_length) {
                        // 새로운 트럭을 다리에 추가
                        waitingTrucks.poll();
                        bridge.add(new int[]{nextTruckWeight, answer});
                        currentWeightOnBridge += nextTruckWeight;
                    }
                }
            }
        }

        return answer;
    }
}