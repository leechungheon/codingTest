import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0과 1의 개수를 저장할 DP 테이블
        int[][] dp = new int[41][2];

        // 초기값 설정
        dp[0][0] = 1; dp[0][1] = 0; // N=0일 때 (1, 0)
        dp[1][0] = 0; dp[1][1] = 1; // N=1일 때 (0, 1)

        // 2부터 40까지 미리 다 계산해두기
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.print(sb);
    }
}