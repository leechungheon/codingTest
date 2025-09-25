class Solution {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] isComputer = new boolean[n];
        for(int i=0; i<isComputer.length; i++)
        {
            if(!isComputer[i]){
                answer++;
                isComputer[i]=true;
                dfs(computers,isComputer, i);
            }
        }
        return answer;
    }
    public void dfs(int[][] computers, boolean[] isComputer, int networkStart){
        //dfs순회하며 boolean true 체크
        for(int i=0; i<computers[networkStart].length; i++){
            if(computers[networkStart][i]==1 && !isComputer[i]){
                isComputer[i]=true;
                dfs(computers,isComputer,i);
            }
        }
    }
}