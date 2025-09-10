import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cameraCount = 0;
        int lastCameraLocation = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int entryPoint = route[0];
            int exitPoint = route[1];

            if (entryPoint > lastCameraLocation) {
                cameraCount++;
                lastCameraLocation = exitPoint;
            }
        }
        
        return cameraCount;
    }
}