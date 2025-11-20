import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static final int LENGTH = 100;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[10];
        int max = 0;

        for(int test_case = 1; test_case <= 10; test_case++){
            // input
            int case_number = sc.nextInt();
            int[][] array = new int[LENGTH][LENGTH];

            for(int row = 0; row < LENGTH; row++){
                for(int col = 0; col < LENGTH; col++){
                    array[row][col] = sc.nextInt();
                }
            }

            // 가로
            for(int row = 0; row < LENGTH; row++){
                int total = 0;
                for(int col = 0; col < LENGTH; col++){
                    total += array[row][col];
                }
                max = Math.max(total, max);
            }

            // 세로
            for(int col = 0; col < LENGTH; col++){
                int total = 0;
                for(int row = 0; row < LENGTH; row++){
                    total += array[row][col];
                }
                max = Math.max(total, max);
            }

            // 대각선-1
            int total=0;
            for(int i=0; i<LENGTH; i++){
                total+=array[i][i];
            }
            max = Math.max(total, max);

            // 대각선-1
            total=0;
            for(int i=LENGTH-1; i>=0; i--){
                total+=array[LENGTH-1-i][i];
            }
            max = Math.max(total, max);

            answers[test_case-1] = max;
            max = 0;
        }
        // output
        for(int i = 0; i < 10; i++){
            System.out.println("#"+(i+1)+" "+answers[i]);
        }
    }
}