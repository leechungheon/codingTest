class Solution {
    int MAX_DIFF = Integer.MIN_VALUE;
    int[] RYAN_SHOTS = new int[]{-1};
    public int[] solution(int n, int[] apeachShots) {
        int[] ryanShots = new int[apeachShots.length];
        dfs(apeachShots, ryanShots, n, 0);
        if (MAX_DIFF <= 0) {
            return new int[]{-1};
        }
        return RYAN_SHOTS;
    }

    public void dfs(int[] apeachShots, int[] ryanShots, int remaining_arrows, int offset) {
        if(offset == apeachShots.length) {
            ryanShots[apeachShots.length-1] = remaining_arrows;
            int diff = calcurateDiff(apeachShots, ryanShots);
            if(diff > MAX_DIFF && diff > 0) {
                MAX_DIFF = diff;
                RYAN_SHOTS = ryanShots.clone();
            }
            if(diff == MAX_DIFF && diff > 0) {
                isPreferred(RYAN_SHOTS, ryanShots);
            }
            ryanShots[10] = 0;
            return; // 종점
        }

        int needed_arrows = apeachShots[offset] + 1;
        if(needed_arrows <= remaining_arrows) {
            ryanShots[offset] = needed_arrows;
            dfs(apeachShots, ryanShots, remaining_arrows - needed_arrows, offset + 1);
            ryanShots[offset] = 0;
        }
        dfs(apeachShots, ryanShots, remaining_arrows, offset + 1);
    }

    public int calcurateDiff(int[] apeachShots, int[] ryanShots) {
        int apeachTotal=0;
        int ryanTotal=0;
        for(int i = 0; i < apeachShots.length; i++){
            if (apeachShots[i] == 0 && ryanShots[i] == 0) {
                continue;
            }

            if(apeachShots[i] >= ryanShots[i]) {
                apeachTotal += 10-i;
            }else{
                ryanTotal += 10-i;
            }
        }
        return  ryanTotal - apeachTotal;
    }

    public void isPreferred(int[] prevShots, int[] currentShots) {
        for(int i = currentShots.length - 1; i >= 0; i--){
            if (currentShots[i] > prevShots[i]) {
                RYAN_SHOTS = currentShots.clone();
                return;
            } else if (currentShots[i] < prevShots[i]) {
                return;
            }
        }
    }
}