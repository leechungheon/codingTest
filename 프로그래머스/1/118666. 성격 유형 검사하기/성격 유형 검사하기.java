class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int r=0,c=0,j=0,a=0;
        for(int i=0; i<survey.length; i++){
            if(survey[i].equals("RT"))r=calculate(choices[i], r, true);
            if(survey[i].equals("TR"))r=calculate(choices[i], r, false);
            if(survey[i].equals("CF"))c=calculate(choices[i], c, true);
            if(survey[i].equals("FC"))c=calculate(choices[i], c, false);
            if(survey[i].equals("JM"))j=calculate(choices[i], j, true);
            if(survey[i].equals("MJ"))j=calculate(choices[i], j, false);
            if(survey[i].equals("AN"))a=calculate(choices[i], a, true);
            if(survey[i].equals("NA"))a=calculate(choices[i], a, false);
        }
        if(r>=0)answer+="R";
        else{
            answer+="T";
        }
        if(c>=0)answer+="C";
        else{
            answer+="F";
        }
        if(j>=0)answer+="J";
        else{
            answer+="M";
        }
        if(a>=0)answer+="A";
        else{
            answer+="N";
        }
        return answer;
    }
    public int calculate(int choices, int std, boolean o){
        switch (choices){
            case 1:
                if(o)std+=3;
                else{
                    std-=3;
                }
                break;
            case 2:
                if(o)std+=2;
                else{
                    std-=2;
                }
                break;
            case 3:
                if(o)std+=1;
                else{
                    std-=1;
                }
                break;
            case 4:
                break;
            case 5:
                if(o)std-=1;
                else{
                    std+=1;
                }
                break;
            case 6:
                if(o)std-=2;
                else{
                    std+=2;
                }
                break;
            case 7:
                if(o)std-=3;
                else{
                    std+=3;
                }
                break;
            default:
                break;
        }
        return std;
    }
}