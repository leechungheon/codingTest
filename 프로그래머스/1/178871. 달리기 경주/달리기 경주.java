import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int n = map.get(callings[i]);
            swap(players, map, n);
        }
        answer = players;
        return answer;
    }

    public void swap(String[] players, Map<String, Integer> map, int i) {
        // Swap the elements in the array
        String temp = players[i];
        players[i] = players[i - 1];
        players[i - 1] = temp;

        // Update the indices in the map
        map.put(players[i], i);
        map.put(players[i - 1], i - 1);
    }
}
