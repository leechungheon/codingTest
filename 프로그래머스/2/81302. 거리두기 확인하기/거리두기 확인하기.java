class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<places.length; i++){
            answer[i]=checkFarAway(places[i]);
        }
        return answer;
    }
    public int checkFarAway(String[] room){
        //문자열 1차원 > 문자형 2차원 배열로 변경
        char[][] newRoom=new char[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                newRoom[i][j]=room[i].charAt(j);
            }
        }

        //P찾고 거리1, 거리2 조사 > 모두 1인 경우에만 1 반환.
        boolean isValid = true;  // 조건을 만족하는지 확인하는 flag

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (newRoom[i][j] == 'P') {
                    // 모든 조건이 1일 때만 통과, 하나라도 만족하지 않으면 isValid를 false로 설정
                    if (!(checkDistance1(newRoom, i, j) == 1 && checkDistance2_straight(newRoom, i, j) == 1 && checkDistance2_cross(newRoom, i, j) == 1)) {
                        isValid = false;  // 조건을 만족하지 않으면 false로 설정
                        break;  // 해당 자리에서 더 이상 검사하지 않고 내부 for문 탈출
                    }
                }
            }
            if (!isValid) {
                break;  // isValid가 false일 때 외부 for문도 탈출
            }
        }
        if (isValid) {
            return 1;  // 모든 검사에서 문제가 없으면 1을 반환
        } else {
            return 0;  // 문제가 있으면 0을 반환
        }
    }
    public int checkDistance1(char[][] newRoom, int i, int j){
        if(i!=0 && newRoom[i-1][j]=='P') { //위에 P
            return 0;
        }else if(j!=4 && newRoom[i][j+1]=='P'){ //오른쪽에 P
            return 0;
        }else if(i!=4 && newRoom[i+1][j]=='P'){ //아래에 P
           return 0;
        }else if(j!=0 && newRoom[i][j-1]=='P') { //왼쪽에 P
            return 0;
        }else{
            return 1;
        }
    }

    //거리가 2이고 직선에 위치한 경우
    public int checkDistance2_straight(char[][] newRoom, int i, int j){
        if(i>1 && newRoom[i-2][j]=='P' && newRoom[i-1][j]!='X'){ //위
            return 0;
        }else if(j<3 && newRoom[i][j+2]=='P' && newRoom[i][j+1]!='X'){ //오른쪽
            return 0;
        }else if(i<3 && newRoom[i+2][j]=='P' && newRoom[i+1][j]!='X'){//아래
            return 0;
        }else if(j>1 && newRoom[i][j-2]=='P' && newRoom[i][j-1]!='X'){//왼쪽
            return 0;
        }else{
            return 1;
        }
    }

    public int checkDistance2_cross(char[][] newRoom, int i, int j){
        if(i!=0 && j!=0 && newRoom[i-1][j-1] =='P'){ //좌상단
            if(newRoom[i-1][j]!='X' || newRoom[i][j-1]!='X'){
                return 0;
            }
        }else if(i != 0 && j != 4 && newRoom[i-1][j+1] == 'P'){ // 우상단
            if(newRoom[i-1][j] != 'X' || newRoom[i][j+1] != 'X'){
                return 0;
            }
        }else if(i != 4 && j != 0 && newRoom[i+1][j-1] == 'P'){ // 좌하단
            if(newRoom[i+1][j] != 'X' || newRoom[i][j-1] != 'X'){
                return 0;
            }
        }else if(i != 4 && j != 4 && newRoom[i+1][j+1] == 'P'){ // 우하단
            if(newRoom[i+1][j] != 'X' || newRoom[i][j+1] != 'X'){
                return 0;
            }
        }
        return 1;
    }
}