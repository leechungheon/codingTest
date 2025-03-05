class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        boolean once=true;
        while(n!=0){

            if(n%3==0){
                n=n/3-1;
                answer.insert(0,"4");
            }else if(n%3==1){
                answer.insert(0,"1");
                n=n/3;
            }else if(n%3==2){
                answer.insert(0,"2");
                n=n/3;
            }
        }

        return answer.toString();
    }
}