class Solution {
    public StringBuilder solution(String number, int k) {
        String answer;
        StringBuilder sb = new StringBuilder("");
        char[] numbersChar = number.toCharArray();
        sb.append(numbersChar[0]);
        for(int i=1; i<numbersChar.length; i++){
            while(sb.length()>0 && numbersChar[i]>sb.charAt(sb.length()-1) && k>0){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
                sb.append(numbersChar[i]);
        }
        // 반복문이 끝난 후에도 k가 남았다면, 남은 k만큼 뒤에서 제거합니다.
        // ex) number = "98765", k = 2
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        answer=sb.toString();
        return new StringBuilder(answer);
    }
}