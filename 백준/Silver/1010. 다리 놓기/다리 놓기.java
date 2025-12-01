import java.util.*;
import java.io.*;

public class Main {
    // DP 테이블 (최대 입력 크기가 30이라고 가정)
    static int[][] dp = new int[31][31];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        // 로직: 미리 테이블을 채워두거나, 재귀로 풉니다.
        // 여기서는 반복문으로 미리 채우는 방식을 보여드릴게요.
        
        // 1. 초기값 세팅
        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1; // i개 중 0개 뽑는 건 1가지
            dp[i][i] = 1; // i개 중 i개 다 뽑는 건 1가지
            dp[i][1] = i; // i개 중 1개 뽑는 건 i가지
        }
        
        // 2. 파스칼의 삼각형 채우기 (점화식)
        for(int i = 2; i <= 30; i++) {
            for(int j = 1; j < i; j++) {
                // nCr = n-1Cr-1 + n-1Cr
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽(N)
            int M = Integer.parseInt(st.nextToken()); // 동쪽(M)
            
            // M개 중에 N개를 뽑는 조합 (MCN)
            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}