import java.util.ArrayList;
import java.util.List;



public class Solution {
    static class GraphNode {
    int x, y;
    List<GraphNode> neighbors;

    public GraphNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }
}
    public int solution(String dirs) {
        int answer=0;
        int rows = 11; // 행 개수
        int cols = 11; // 열 개수

        // 2차원 배열로 그래프 노드 생성
        GraphNode[][] graph = new GraphNode[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph[i][j] = new GraphNode(i, j);
            }
        }
        int x=5,y=5;

        // 인접 노드 연결 (예: 상하좌우)
        for(int i=0; i<dirs.length(); i++){
            if (dirs.charAt(i) == 'U' && y + 1 < 11) {
                if (!graph[x][y].neighbors.contains(graph[x][y + 1])) {
                    graph[x][y].addNeighbor(graph[x][y + 1]); // 현재 노드에서 위쪽 노드로 간선 추가
                    graph[x][y + 1].addNeighbor(graph[x][y]); // 위쪽 노드에서 현재 노드로 간선 추가 (양방향)
                    answer++;
                }
                y++; // 좌표값 증가
            } else if (dirs.charAt(i) == 'R' && x + 1 < 11) {
                if (!graph[x][y].neighbors.contains(graph[x + 1][y])) {
                    graph[x][y].addNeighbor(graph[x + 1][y]); // 현재 노드에서 오른쪽 노드로 간선 추가
                    graph[x + 1][y].addNeighbor(graph[x][y]); // 오른쪽 노드에서 현재 노드로 간선 추가 (양방향)
                    answer++;
                }
                x++; // 좌표값 증가
            } else if (dirs.charAt(i) == 'D' && y - 1 >= 0) {
                if (!graph[x][y].neighbors.contains(graph[x][y - 1])) {
                    graph[x][y].addNeighbor(graph[x][y - 1]); // 현재 노드에서 아래쪽 노드로 간선 추가
                    graph[x][y - 1].addNeighbor(graph[x][y]); // 아래쪽 노드에서 현재 노드로 간선 추가 (양방향)
                    answer++;
                }
                y--; // 좌표값 감소
            } else if (dirs.charAt(i) == 'L' && x - 1 >= 0) {
                if (!graph[x][y].neighbors.contains(graph[x - 1][y])) {
                    graph[x][y].addNeighbor(graph[x - 1][y]); // 현재 노드에서 왼쪽 노드로 간선 추가
                    graph[x - 1][y].addNeighbor(graph[x][y]); // 왼쪽 노드에서 현재 노드로 간선 추가 (양방향)
                    answer++;
                }
                x--; // 좌표값 감소
            }


        }
        return answer;


    }
}
