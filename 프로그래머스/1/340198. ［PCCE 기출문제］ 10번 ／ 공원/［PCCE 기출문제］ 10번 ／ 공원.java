import java.util.*;

class Solution {
    static String[][] park;

    // 돗자리가 (x, y)에서 시작하는 정사각형으로 깔릴 수 있는지 체크하는 함수
    static boolean check(int x, int y, int size) {
        int n = park.length;
        int m = park[0].length;

        // 돗자리가 공원의 경계를 넘는지 확인
        if (x + size > n || y + size > m) return false;

        // size x size 영역에 다른 사람이 있는지 확인
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!"-1".equals(park[x + i][y + j])) {
                    return false; // 사람이 있으면 false 반환
                }
            }
        }
        return true; // 깔 수 있으면 true 반환
    }

    public int solution(int[] mats, String[][] inputPark) {
        park = inputPark; // 전역 변수에 공원 정보를 할당
        Arrays.sort(mats); // 돗자리를 작은 것부터 큰 것 순으로 정렬
        int maxMat = -1; // 깔 수 있는 가장 큰 돗자리 크기를 저장

        // 공원의 모든 좌표에 대해 돗자리를 깔 수 있는지 확인
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if ("-1".equals(park[i][j])) { // 현재 위치가 빈 공간일 때만
                    // 각 돗자리 크기에 대해 확인
                    for (int matSize : mats) {
                        if (check(i, j, matSize)) {
                            maxMat = Math.max(maxMat, matSize); // 가장 큰 돗자리 크기를 저장
                        }
                    }
                }
            }
        }

        return maxMat;
    }
}