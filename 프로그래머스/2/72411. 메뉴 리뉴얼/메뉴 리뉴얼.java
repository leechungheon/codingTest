import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> answerList = new ArrayList<>();

        // 1. 주문한 메뉴들을 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = new String(order);
        }

        // 2. course에 있는 길이만큼의 조합을 구해서 map에 저장
        for (int len : course) {
            map.clear(); // 각 길이마다 새로운 조합을 저장하기 위해 초기화

            for (String order : orders) {
                if (order.length() < len) continue;
                comb(order, len, 0, "", map);
            }

            // 3. 가장 많이 주문된 조합을 찾기
            int maxValue = 2; // 최소 2명 이상 주문해야 함
            List<String> tempList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    tempList.clear();
                    tempList.add(entry.getKey());
                } else if (entry.getValue() == maxValue) {
                    tempList.add(entry.getKey());
                }
            }

            answerList.addAll(tempList);
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 백트래킹을 이용한 조합 생성
    public void comb(String order, int len, int start, String current, HashMap<String, Integer> map) {
        if (current.length() == len) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            comb(order, len, i + 1, current + order.charAt(i), map);
        }
    }
}
