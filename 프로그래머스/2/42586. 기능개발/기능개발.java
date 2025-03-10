import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tempList = new ArrayList<>();
        int[] days = new int[progresses.length];

        // 각 작업의 완료까지 필요한 날짜 계산
        for (int i = 0; i < days.length; i++) {
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                days[i] = (100 - progresses[i]) / speeds[i];
            }
        }

        // days 배열의 값들을 오름차순 정렬된 TreeSet에 저장하여 중복 제거
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int day : days) {
            treeSet.add(day);
        }

        // TreeSet의 값을 배열 uniqueDays에 저장
        int[] uniqueDays = new int[treeSet.size()];
        int index = 0;
        for (Integer num : treeSet) {
            uniqueDays[index++] = num;
        }

        boolean once = true;
        // 모든 작업이 완료될 때까지 반복
        while (checkProgresses(days) != days.length) {
            for (int j = 0; j < uniqueDays.length; j++) {
                for (int i = 0; i < days.length; i++) {
                    if (days[i] == uniqueDays[j]) {
                        days[i] = 0;
                    }
                }
                int currentCount = checkProgresses(days);
                if (currentCount != 0 && once) {
                    tempList.add(currentCount);
                    once = false;
                } else {
                    if (tempList.isEmpty()) {
                        if (currentCount != 0) {
                            tempList.add(currentCount);
                        }
                    } else {
                        if (currentCount != tempList.get(tempList.size() - 1)) {
                            tempList.add(currentCount);
                        }
                    }
                }
            }
        }
        
        // ArrayList를 int 배열로 변환
        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        
        // 차이를 구해서 각 배포되는 작업의 수 계산
        for (int i = answer.length - 1; i >= 1; i--) {
            answer[i] = answer[i] - answer[i - 1];
        }
        return answer;
    }

    public int checkProgresses(int[] days) {
        int start = 0;
        int count = 0;
        while (start < days.length && days[start] <= 0) {
            count++;
            start++;
        }
        return count;
    }
}
