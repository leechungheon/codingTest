import java.util.*;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] answers = new int[T];

		for(int test_case = 1; test_case <= T; test_case++)
		{
            // input & settings
            int students=sc.nextInt();
            
            int[][] move = new int[students][2];
            for(int i=0; i<move.length; i++){
                for(int j=0; j<move[0].length; j++){
                    move[i][j]=sc.nextInt();
                }
            }
            
            int[] corridor = new int[201];

            //logic
            for(int i=0; i<move.length; i++){
                if(move[i][0]>move[i][1]){
                    int temp = move[i][1];
                    move[i][1]=move[i][0];
                    move[i][0]=temp;
                }
                for(int j=(move[i][0]+1)/2; j<=(move[i][1]+1)/2; j++){
                    corridor[j]++;
                }
            }
            int max = 0;
            for(int i=0; i<corridor.length; i++){
                max=Math.max(max,corridor[i]);
            }
            answers[test_case-1]=max;
		}

        // output
        for(int i=0; i<answers.length; i++){
            System.out.println("#"+(i+1)+" "+answers[i]);
        }
	}
}