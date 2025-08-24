class Solution {
    static int answer = 0;
    static int maxCount=0;
    public int solution(int k, int[][] dungeons) {

        boolean[] unable=new boolean[dungeons.length];

        dungeonCount(k,dungeons,unable,0);
        return maxCount;
    }
    public static void dungeonCount(int k, int[][] dungeons,boolean[] unable, int count){
        // 재귀 호출이 끝날 때마다 최대 던전 수를 갱신
        maxCount = Math.max(maxCount, count);
        for(int i=0; i< dungeons.length; i++){
            if(unable[i])continue;
            if(dungeons[i][0] <= k){ // 조건 변경: 최소 필요 피로도가 현재 피로도보다 작거나 같을 때
                unable[i] = true;
                dungeonCount(k - dungeons[i][1], dungeons, unable, count + 1);
                unable[i] = false; // 백트래킹
            }
        }
    }
}