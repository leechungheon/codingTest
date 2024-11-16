class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int size=attacks[attacks.length-1][0];
        int[] array =new int[size+1];
        array[0]=health;
        for(int i=0; i<attacks.length; i++){
            int dmg=attacks[i][1];
            int timing=attacks[i][0];
            array[timing]=-dmg;
        }

        int time=bandage[0];
        int healing=bandage[1];
        int bonus=bandage[2];
        int cnt=0;

        for(int i=1; i<size+1; i++){
            if(array[i]>=0){
                array[i]+=healing;
                cnt++;
                if(cnt==time){
                    array[i]+=bonus;
                    cnt=0;
                }
            }else{
                cnt=0;
            }
        }

        for(int i=0; i<size; i++){
            array[i+1]+=array[i];
            if(array[i+1]>health)array[i+1]=health;
            if(array[i+1]<=0){
                answer=-1;
                break;
            }
        }
        if(answer!=-1)answer=array[size];

        return answer;
    }
}