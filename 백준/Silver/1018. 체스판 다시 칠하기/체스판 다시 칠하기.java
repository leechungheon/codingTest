import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        //
        int minChanges = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if(i+8 > N)continue;
            for (int j = 0; j < M; j++) {
                if(j+8 > M)break;
                int result = calculateMinChanges(i, j, board);
                minChanges = Math.min(minChanges,result);
            }
        }
        //
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(minChanges));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
    public static int calculateMinChanges(int i, int j, char[][] board){
        int blackStartMin=0;
        int whiteStartMin=0;
        char[][] whiteStartBoard = new char[8][8];
        char[][] blackStartBoard = new char[8][8];
        for(int n=0; n<8; n++){
            if(n%2 == 0){
                whiteStartBoard[n][0] ='W';
                blackStartBoard[n][0] ='B';
            }else{
                whiteStartBoard[n][0] ='B';
                blackStartBoard[n][0] ='W';
            }
            for(int m=1; m<8; m++){
                if(whiteStartBoard[n][m-1] == 'W'){
                    whiteStartBoard[n][m] = 'B';
                    blackStartBoard[n][m] ='W';
                }else{
                    whiteStartBoard[n][m] = 'W';
                    blackStartBoard[n][m] ='B';
                }
            }
        }
        for(int n=0; n<8; n++){
            for(int m=0; m<8; m++){
                if(board[i+n][j+m] != whiteStartBoard[n][m]){
                    whiteStartMin++;
                }
                if(board[i+n][j+m] != blackStartBoard[n][m]){
                    blackStartMin++;
                }
            }
        }
        return Math.min(whiteStartMin,blackStartMin);
    }
}