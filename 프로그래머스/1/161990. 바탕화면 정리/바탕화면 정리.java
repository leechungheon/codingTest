class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX=50, minY=50, maxX=0, maxY=0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX=Math.min(minX,j);
                    minY=Math.min(minY,i);
                    maxX=Math.max(maxX,j);
                    maxY=Math.max(maxY,i);
                }
            }
        }
        maxX++;maxY++;
        answer[0]=minY;
        answer[1]=minX;
        answer[2]=maxY;
        answer[3]=maxX;
        return answer;
    }
}