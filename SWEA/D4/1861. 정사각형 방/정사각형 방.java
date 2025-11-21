import java.util.*;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[][] answers = new int[T][2];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // input & settings
            int N=sc.nextInt();
            int[][] A = new int[N][N];
            for(int i=0; i<A.length; i++){
                for(int j=0; j<A[0].length; j++){
                    A[i][j]=sc.nextInt();
                }
            }

            // logic
            int max=0;
            int start_i=0;
            int start_j=0;
            for(int i=0; i<A.length; i++){
                for(int j=0; j<A[0].length; j++){
                    int currentLength=findDistance(i,j,A,1);
                    if(max<currentLength){
                        max =  currentLength;
                        start_i=i;
                        start_j=j;
                    }else if(max==currentLength && A[i][j]<A[start_i][start_j]){
                        start_i = i;
                        start_j = j;
                    }
                }
            }

            // save
            answers[test_case-1][0]=A[start_i][start_j];
            answers[test_case-1][1]=max;
        }

        // output
        for(int i=0; i<T; i++){
            System.out.println("#"+(i+1)+" "+answers[i][0]+" "+answers[i][1]);
        }
    }

    public static int findDistance(int i, int j, int[][] A, int len){
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        for(int t=0; t<4; t++){
            int ni = i+di[t];
            int nj = j+dj[t];
            if(ni>=0 && nj>=0 && ni<A.length && nj<A.length && A[ni][nj]==A[i][j]+1){
                len = findDistance(ni,nj,A,len+1);
            }
        }
        return len;
    }
}