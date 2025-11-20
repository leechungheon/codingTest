import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int max = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] answers = new int[T];

		for(int test_case = 1; test_case <= T; test_case++)
		{
            // input
            int N = sc.nextInt(); // 재료의 수
            int L = sc.nextInt(); // 제한 칼로리
            int[][] ingredient = new int[N][2]; // [재료 점수][재료 칼로리]
            for(int i=1; i<=N; i++){
                ingredient[i-1][0] = sc.nextInt();
                ingredient[i-1][1] = sc.nextInt();
            }

            // logic
            dfs(0,L,0,ingredient,0);
            answers[test_case-1] = max;
            max = 0;

            
		}
        // output
            for(int i=0; i<answers.length; i++){
                System.out.println("#"+(i+1)+" "+answers[i]);
            }
	}

    public static void dfs(int current_calories, int limit_calories, int score, int[][] ingredient, int idx){
        // 종료 조건
        if(current_calories > limit_calories){
            return;
        }
        if(idx == ingredient.length){
            max = Math.max(max, score);
            return;
        }

        // 순회 조건

        // idx의 재료를 넣을 때
        dfs(current_calories + ingredient[idx][1],limit_calories,score+ ingredient[idx][0],ingredient,idx+1);
        // idx의 재료를 넣지 않을 때
        dfs(current_calories,limit_calories,score,ingredient,idx+1);
    }
}