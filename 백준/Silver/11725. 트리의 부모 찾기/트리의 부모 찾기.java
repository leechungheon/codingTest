import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        /* 기존 인접 행렬 방식 (주석 처리)
        int[][] adj = new int[N+1][N+1];
        */

        // 인접 리스트 방식: 노드마다 연결된 노드 번호만 동적으로 저장
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] parents = new int[N + 1];
        boolean[] visited = new boolean[N + 1]; // 방문 처리용 배열

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /* 기존 인접 행렬 데이터 삽입 (주석 처리)
            adj[x][y] = 1;
            adj[y][x] = 1;
            */

            // 인접 리스트 데이터 삽입
            adj[x].add(y);
            adj[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true; // 루트 노드 방문 처리

        while (!q.isEmpty()) {
            int num = q.poll();

            /* 기존 인접 행렬 기반 탐색 (주석 처리)
            for(int i=1; i<=N; i++) {
                if(adj[num][i]==1) {
                    q.add(i);
                    parents[i]=num;
                    adj[i][num]=0;
                    adj[num][i]=0;
                }
            }
            */

            // 인접 리스트 기반 탐색: 연결된 노드만 순회하여 효율적임
            for (int neighbor : adj[num]) {
                if (!visited[neighbor]) { // 아직 방문하지 않은 노드라면 자식 노드임
                    visited[neighbor] = true;
                    parents[neighbor] = num; // 부모 노드 저장
                    q.add(neighbor);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}