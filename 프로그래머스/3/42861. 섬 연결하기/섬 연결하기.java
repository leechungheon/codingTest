import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesCount = 0;

        for (int[] edge : costs) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            if (findParent(parent, start) != findParent(parent, end)) {
                unionParent(parent, start, end);
                totalCost += cost;
                edgesCount++;
            }
            
            if (edgesCount == n - 1) {
                break;
            }
        }

        return totalCost;
    }

    private int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    private void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}