import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑으려는 숫자의 개수

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int totalCount = 0;

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            
            int targetIdx = list.indexOf(target);
            int halfIdx = list.size() / 2;

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    list.addLast(list.removeFirst());
                    totalCount++;
                }
            } else {
                for (int j = 0; j < list.size() - targetIdx; j++) {
                    list.addFirst(list.removeLast());
                    totalCount++;
                }
            }

            list.removeFirst();
        }

        System.out.println(totalCount);
    }
}