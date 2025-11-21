import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static class Node {
        int x, y, point;
        int[][] min_cost;

        public Node(int x, int y, int point, int[][] min_cost) {
            this.x = x;
            this.y = y;
            this.point = point;
            this.min_cost = min_cost;
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] answers = new int[T];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int map_size = sc.nextInt();
            int[][] map = new int[map_size][map_size];
            for(int i=0; i<map_size; i++){
                String line = sc.next();
                for(int j=0; j<map_size; j++){
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};

            int[][] min_cost = new int[map_size][map_size];
            for(int i=0; i<min_cost.length; i++){
                for(int j=0; j<min_cost[0].length; j++){
                    min_cost[i][j] = Integer.MAX_VALUE;
                }
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0,0,0,min_cost));
            while(!queue.isEmpty())
            {
                Node node = queue.poll();
                // 상하좌우
                for(int i=0; i<4; i++){
                    int nx=node.x+dx[i];
                    int ny=node.y+dy[i];
                    if(nx>=0 && ny>=0 && nx<map_size && ny<map_size && node.point+map[nx][ny] < min_cost[nx][ny]){
                        min_cost[nx][ny]=node.point+map[nx][ny];
                        queue.add(new Node(nx,ny,node.point+map[nx][ny],min_cost));
                    }
                }
            }
            answers[test_case-1] = min_cost[map_size-1][map_size-1];
        }

        for(int i=0; i<T; i++){
            System.out.println("#"+(i+1)+" "+answers[i]);
        }
    }
}