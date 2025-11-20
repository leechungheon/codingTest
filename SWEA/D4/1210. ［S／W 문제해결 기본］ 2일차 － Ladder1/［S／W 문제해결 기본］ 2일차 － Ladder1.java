import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[10];

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            // input
            int[][] array = new int[100][100];
            int test_number = sc.nextInt();
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    array[i][j] = sc.nextInt();
                }
            }

            // logic
            for(int i = 0; i < 100; i++){
                // function
                if(array[0][i] == 1){
                    if(radderFindIndex(0,i, array)==2){
                        answers[test_case-1] = i;
                        break;
                    }
                }

            }
        }

        // output
        for(int i = 0; i < 10; i++){
            System.out.println("#"+(i+1) + " " + answers[i]);
        }
    }

    public static int radderFindIndex(int x, int y, int[][] array){
        if(array[x][y]==2){
            return 2;
        }
        if(x==99){
            return 1;
        }
        // 좌측 또는 우측에 길이 있는 경우
        if(y-1>=0 && array[x][y-1]==1){
            while(y-1>=0 && array[x][y-1]==1){
                y-=1;
            }
        }else if(y+1<100 && array[x][y+1]==1){
            while(y+1<100 && array[x][y+1]==1){
                y+=1;
            }
        }
        // 좌우측에 길이 없고 내려가는 경우
        return radderFindIndex(x+1, y, array);
    }
}