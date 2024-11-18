class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int cnt=0;
        String[] video_len1=video_len.split(":");
        int video_len_min=Integer.parseInt(video_len1[0]);
        int video_len_sec=Integer.parseInt(video_len1[1]);
        int video_len_total=video_len_min*60+video_len_sec;

        String[] pos1=pos.split(":");
        int pos_min=Integer.parseInt(pos1[0]);
        int pos_sec=Integer.parseInt(pos1[1]);
        int pos_total=pos_min*60+pos_sec;

        String[] op_start1=op_start.split(":");
        int op_start_min=Integer.parseInt(op_start1[0]);
        int op_start_sec=Integer.parseInt(op_start1[1]);
        int op_start_total=op_start_min*60+op_start_sec;

        String[] op_end1=op_end.split(":");
        int op_end_min=Integer.parseInt(op_end1[0]);
        int op_end_sec=Integer.parseInt(op_end1[1]);
        int op_end_total=op_end_min*60+op_end_sec;

        while(true){
            if(pos_total>=op_start_total && pos_total<=op_end_total){
                pos_total=op_end_total;
            }
            if(commands[cnt].equals("prev")){
                if(pos_total-10<0){
                    pos_total=0;
                }else{
                    pos_total-=10;
                }
            } else if (commands[cnt].equals("next")) {
                if(pos_total+10>video_len_total){
                    pos_total=video_len_total;
                }else{
                    pos_total+=10;
                }
            }
            if(cnt+1== commands.length){
                if(pos_total>=op_start_total && pos_total<=op_end_total){
                    pos_total=op_end_total;
                }
                break;
            }else{
                cnt++;
            }
        }

        int answer_min=pos_total/60;
        int answer_sec=pos_total%60;
        answer = String.format("%02d:%02d", answer_min, answer_sec);

        return answer;
    }
    
}