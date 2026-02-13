import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        // 1. 보석 정보 입력 (무게와 가치)
        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // 2. 가방 정보 입력 (무게 한도)
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬 전략
        // 보석은 무게순으로 오름차순
        Arrays.sort(jewels, (o1, o2) -> o1[0] - o2[0]);
        // 가방도 무게순으로 오름차순 (작은 가방부터 채워야 효율적임)
        Arrays.sort(bags);

        // 4. 우선순위 큐 (최대 힙) - 가치가 높은 순서대로 정렬됨
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long totalPrice = 0; // 결과값이 int 범위를 넘을 수 있으므로 long 사용
        int jewelIdx = 0;

        // 5. 그리디 알고리즘 실행
        for (int i = 0; i < K; i++) {
            // 현재 가방의 무게 한도(bags[i])에 들어갈 수 있는 모든 보석을 큐에 넣음
            // 보석이 무게순으로 정렬되어 있어 jewelIdx를 초기화하지 않고 계속 이어감
            while (jewelIdx < N && jewels[jewelIdx][0] <= bags[i]) {
                pq.offer(jewels[jewelIdx][1]);
                jewelIdx++;
            }

            // 큐에 보석이 있다면, 그중 가장 가치가 높은 보석 하나를 꺼내 가방에 넣음
            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        // 6. 결과 출력
        System.out.println(totalPrice);
    }
}