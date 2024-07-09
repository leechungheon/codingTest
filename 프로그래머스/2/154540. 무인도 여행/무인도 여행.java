import java.util.*;

public class Solution {
    static class Search {
        char[][] array;
        boolean[][] visited;
        int total = 0;

        public Search(char[][] array) {
            this.array = array;
            this.visited = new boolean[array.length][array[0].length];
        }

        public int start(int i, int j) {
            if (array[i][j] == 'X' || visited[i][j]) return 0; // 방문한 곳이거나 'X'인 경우 0 반환

            visited[i][j] = true; // 방문 표시
            total += Character.getNumericValue(array[i][j]); // 현재 숫자 더하기

            // 오른쪽으로 이동
            if (j + 1 < array[i].length) {
                start(i, j + 1);
            }
            // 아래쪽으로 이동
            if (i + 1 < array.length) {
                start(i + 1, j);
            }
            // 왼쪽으로 이동
            if (j - 1 >= 0) {
                start(i, j - 1);
            }
            // 위쪽으로 이동
            if (i - 1 >= 0) {
                start(i - 1, j);
            }

            return total; // 현재 집합의 합 반환
        }
    }

    public int[] solution(String[] maps) {
        // 문자형 2차원 배열 생성 및 초기화
        char[][] twoDimensionalArray = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            twoDimensionalArray[i] = maps[i].toCharArray();
        }

        List<Integer> results = new ArrayList<>();
        Search search = new Search(twoDimensionalArray);

        // 모든 시작점에 대해 탐색 실행
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                int result = search.start(i, j);
                if (result != 0) {
                    results.add(result);
                }
                search.total = 0; // 다음 탐색을 위해 total 초기화
            }
        }

        // 정렬
        Collections.sort(results);

        // 결과 배열 생성 및 반환
        int[] answer = new int[results.size()];
        for (int k = 0; k < results.size(); k++) {
            answer[k] = results.get(k);
        }

        if (answer.length == 0) {
            answer = new int[]{-1}; // 경로가 없는 경우 -1로 설정
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] maps = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };

        Solution solution = new Solution();
        int[] result = solution.solution(maps);

        // 결과 출력
        System.out.println("Result: " + Arrays.toString(result));
    }
}
