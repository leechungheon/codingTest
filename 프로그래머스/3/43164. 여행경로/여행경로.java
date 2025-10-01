import java.util.*;

class Solution {
    LinkedList<String[]> list = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, 0, visited, answer);
        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                int compare = o1[i].compareTo(o2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        });
        return list.poll();
    }

    public void dfs(String[][] tickets, int offset, boolean[] visited, String[] answer) {
        if (offset == tickets.length) {
            list.add(answer);
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(answer[offset])) {
                visited[i] = true;
                String[] newAnswer = answer.clone();
                newAnswer[offset + 1] = tickets[i][1];
                dfs(tickets, offset + 1, visited, newAnswer);
                visited[i] = false;
            }
        }
    }
}