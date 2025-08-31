import java.io.*;
import java.util.*;

// 그래프의 간선 정보를 담기 위한 클래스 (상황에 맞게 수정 가능)
class Node implements Comparable<Node> {
    int to;
    int cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 출력을 한번에 모아서 처리하기 위함

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N : 장소의 수 (노드)
            int M = Integer.parseInt(st.nextToken()); // M : 도로의 수 (간선)

            // 입력 종료 조건
            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 시작점
            int D = Integer.parseInt(st.nextToken()); // 도착점

            // 그래프 정보를 저장할 정방향/역방향 인접 리스트
            ArrayList<ArrayList<Node>> adj = new ArrayList<>();
            ArrayList<ArrayList<Node>> reverseAdj = new ArrayList<>();

            for (int i = 0; i < N; i++) { // 인접 리스트 생성
                adj.add(new ArrayList<>());
                reverseAdj.add(new ArrayList<>());
            }

            // M개의 간선 정보 입력받기
            // U에서 V로 가는 도로의 길이가 P이다.
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                adj.get(U).add(new Node(V, P));
                reverseAdj.get(V).add(new Node(U, P)); //역방향
            }

            // 1. 첫 번째 다익스트라를 실행하여 S에서 모든 노드까지의 최단 거리를 구합니다.
            int[] dist=dijkstra(S,N,adj);

            // 2. 도착점(D)에서부터 경로를 역추적하여 최단 경로에 포함되는 모든 간선을 찾습니다.
            boolean[][] isShortestPath = new boolean[N][N];
            // 도착점까지의 경로가 존재할 때만 역추적 수행
            if (dist[D] != Integer.MAX_VALUE) {
                bfsToTracePath(S, D, dist, reverseAdj, isShortestPath, N);
            }

            // 3. 최단 경로에 포함된 간선들을 제외하고, 두 번째 다익스트라를 실행합니다.
            int[] secondDist = dijkstra(S, N, adj, isShortestPath);

            // 4. 두 번째 다익스트라 결과로 나온 D까지의 최단 경로를 StringBuilder에 추가합니다.
            int result = secondDist[D];
            if (result == Integer.MAX_VALUE) {
                sb.append(-1).append("\n"); // 거의 최단 경로가 존재하지 않는 경우
            } else {
                sb.append(result).append("\n");
            }
        }

        // 모아둔 결과 한 번에 출력
        System.out.print(sb);
    }
    private static int[] dijkstra(int start, int N, ArrayList<ArrayList<Node>> adj) {
        // 1. 초기화 작업
        int[] dist = new int[N]; // 최단 거리 저장 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 모든 값을 무한대로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 2. 시작 노드 설정
        dist[start] = 0;
        pq.add(new Node(start, 0)); // 우선순위 큐에 시작 노드 추가

        // 3. 다익스트라 알고리즘 실행
        while (!pq.isEmpty()) {
            // 현재 가장 짧은 거리를 가진 노드를 꺼냄
            Node currentNode = pq.poll();
            int currentTo = currentNode.to;
            int currentCost = currentNode.cost;

            // 큐에서 꺼낸 비용이 이미 기록된 최단 거리보다 크다면,
            // 이 경로는 더 이상 볼 필요가 없으므로 무시한다. (핵심 최적화)
            if (currentCost > dist[currentTo]) {
                continue;
            }

            // 현재 노드와 연결된 모든 주변 노드를 탐색
            for (Node nextNode : adj.get(currentTo)) {
                int nextTo = nextNode.to;
                int nextCost = nextNode.cost;

                // 새로운 경로의 비용 계산: (시작점 -> 현재노드) + (현재노드 -> 다음노드)
                int newPathCost = dist[currentTo] + nextCost;

                // 새로운 경로가 기존 경로보다 더 짧은 경우
                if (newPathCost < dist[nextTo]) {
                    dist[nextTo] = newPathCost; // 최단 거리 갱신
                    pq.add(new Node(nextTo, newPathCost)); // 갱신된 정보를 큐에 추가
                }
            }
        }

        return dist;
    }
    private static void bfsToTracePath(int start, int dest, int[] dist, ArrayList<ArrayList<Node>> reverseAdj, boolean[][] isShortestPath, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(dest);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // 시작점에 도달하면 더 이상 역추적할 필요 없음
            if (currentNode == start) {
                continue;
            }

            // 현재 노드로 들어오는 모든 간선을 역방향 그래프에서 찾는다.
            for (Node prevNodeInfo : reverseAdj.get(currentNode)) {
                int prevNode = prevNodeInfo.to;
                int cost = prevNodeInfo.cost;

                // 최단 경로 조건 확인
                // (S -> 이전 노드 최단거리) + (이전 -> 현재 노드 비용) == (S -> 현재 노드 최단거리)
                if (dist[prevNode] + cost == dist[currentNode]) {

                    // 아직 체크되지 않은 최단 경로 간선인 경우
                    if (!isShortestPath[prevNode][currentNode]) {
                        isShortestPath[prevNode][currentNode] = true;
                        queue.add(prevNode); // 다음 역추적을 위해 큐에 추가
                    }
                }
            }
        }
    }
    private static int[] dijkstra(int start, int N, ArrayList<ArrayList<Node>> adj, boolean[][] isShortestPath) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentTo = currentNode.to;
            int currentCost = currentNode.cost;

            if (currentCost > dist[currentTo]) {
                continue;
            }

            for (Node nextNode : adj.get(currentTo)) {
                int nextTo = nextNode.to;
                int nextCost = nextNode.cost;

                // isShortestPath 배열이 null이 아니고, 현재 간선이 최단 경로에 포함된 간선이라면 무시한다.
                if (isShortestPath != null && isShortestPath[currentTo][nextTo]) {
                    continue;
                }

                int newPathCost = dist[currentTo] + nextCost;
                if (newPathCost < dist[nextTo]) {
                    dist[nextTo] = newPathCost;
                    pq.add(new Node(nextTo, newPathCost));
                }
            }
        }
        return dist;
    }
}