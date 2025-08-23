import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answer_index=0;

        for(int i=0; i<commands.length; i++){
                int[] tem=new int[commands[i][1]-commands[i][0]+1];
                int tem_index=0;

                for(int z=commands[i][0]-1; z<commands[i][1]; z++){
                    tem[tem_index]=array[z];
                    tem_index++;
                }
            Arrays.sort(tem);
                answer[answer_index]=tem[commands[i][2]-1];
                answer_index++;
        }

        return answer;
    }
}