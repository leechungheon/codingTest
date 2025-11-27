import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        // 1. 원본 배열 (순서 유지용)
        int[] origin = new int[N];
        // 2. 정렬할 배열 (등수 계산용)
        int[] sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
            sorted[i] = num;
        }
        
        // 3. 정렬 (O(N log N))
        Arrays.sort(sorted);
        
        // 4. 랭킹 매기기 (중복 제거하며 Map에 저장)
        // Key: 원래 숫자, Value: 압축된 좌표(등수)
        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        int rank = 0;
        
        for(int v : sorted) {
            // 만약 맵에 없는 숫자라면? (중복 제거 효과)
            if(!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++; // 다음 등수로 증가
            }
        }
        
        // 5. 원본 순서대로 출력 (O(1)로 조회)
        for(int key : origin) {
            // indexOf 대신 map.get()을 쓰면 비교도 안 되게 빠름
            sb.append(rankingMap.get(key)).append(" ");
        }
        
        System.out.println(sb);
    }
}