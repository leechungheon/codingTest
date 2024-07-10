import java.security.Key;

class Solution {
    class Keypad{
        int i;
        int j;
        public Keypad(int i, int j){
            this.i=i;
            this.j=j;
        }
        public int distance(Keypad keypad) {
            int a=this.i-keypad.i; if(a<0)a*=-1;
            int b=this.j-keypad.j; if(b<0)b*=-1;
            return a+b;
        }
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Keypad[][] keypad = new Keypad[4][3];
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                keypad[i][j]=new Keypad(i,j);
            }
        }
        Keypad leftHand = keypad[3][0];
        Keypad rightHand = keypad[3][2];
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 ||numbers[i]==7){
                answer.append("L");
                if(numbers[i]==1)leftHand=keypad[0][0];
                if(numbers[i]==4)leftHand=keypad[1][0];
                if(numbers[i]==7)leftHand=keypad[2][0];
            }
            if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer.append("R");
                if(numbers[i]==3)rightHand=keypad[0][2];
                if(numbers[i]==6)rightHand=keypad[1][2];
                if(numbers[i]==9)rightHand=keypad[2][2];
            }
            if(numbers[i]==2 || numbers[i]==5 || numbers[i]==8 || numbers[i]==0){
                if(numbers[i]==2){
                    int a=keypad[0][1].distance(leftHand);
                    int b=keypad[0][1].distance(rightHand);
                    if(a<b){
                        leftHand=keypad[0][1];
                        answer.append("L");
                    }else if(a>b){
                        rightHand=keypad[0][1];
                        answer.append("R");
                    }else{
                        if(hand.equals("right")){
                            rightHand=keypad[0][1];
                            answer.append("R");
                        }else{
                            leftHand=keypad[0][1];
                            answer.append("L");
                        }
                    }
                }
                if(numbers[i]==5){
                    int a=keypad[1][1].distance(leftHand);
                    int b=keypad[1][1].distance(rightHand);
                    if(a<b){
                        leftHand=keypad[1][1];
                        answer.append("L");
                    }else if(a>b){
                        rightHand=keypad[1][1];
                        answer.append("R");
                    }else{
                        if(hand.equals("right")){
                            rightHand=keypad[1][1];
                            answer.append("R");
                        }else{
                            leftHand=keypad[1][1];
                            answer.append("L");
                        }
                    }
                }
                if(numbers[i]==8){
                    int a=keypad[2][1].distance(leftHand);
                    int b=keypad[2][1].distance(rightHand);
                    if(a<b){
                        leftHand=keypad[2][1];
                        answer.append("L");
                    }else if(a>b){
                        rightHand=keypad[2][1];
                        answer.append("R");
                    }else{
                        if(hand.equals("right")){
                            rightHand=keypad[2][1];
                            answer.append("R");
                        }else{
                            leftHand=keypad[2][1];
                            answer.append("L");
                        }
                    }
                }
                if(numbers[i]==0){
                    int a=keypad[3][1].distance(leftHand);
                    int b=keypad[3][1].distance(rightHand);
                    if(a<b){
                        leftHand=keypad[3][1];
                        answer.append("L");
                    }else if(a>b){
                        rightHand=keypad[3][1];
                        answer.append("R");
                    }else{
                        if(hand.equals("right")){
                            rightHand=keypad[3][1];
                            answer.append("R");
                        }else{
                            leftHand=keypad[3][1];
                            answer.append("L");
                        }
                    }
                }
            }
        }

        return answer.toString();
    }
}