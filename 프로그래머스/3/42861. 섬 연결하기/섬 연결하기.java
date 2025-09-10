import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static int answer=0;
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
    public int solution(int n, int[][] costs) {
        boolean[] visited = new boolean[n+1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 인접리스트 생성
        for (int[] cost : costs) {
            graph.get(cost[0]).add(new Node(cost[1], cost[2]));
            graph.get(cost[1]).add(new Node(cost[0], cost[2]));
        }
        dijkstra(0, graph, visited, n);
        return answer;
    }

    public void dijkstra(int start, ArrayList<ArrayList<Node>> graph, boolean[] visited, int n) {
        int checkedNode=0;
        Queue<Node> q1=new PriorityQueue<>();
        q1.add(new Node(start,0));
        while(!q1.isEmpty()){
            Node node=q1.poll();
            if(visited[node.to]) continue;
            visited[node.to]=true;
            checkedNode++;
            answer+=node.cost;
            for(Node next:graph.get(node.to)){
                if(!visited[next.to]){
                    q1.add(next);
                }
            }
            if(checkedNode==n) break;
        }
    }
}