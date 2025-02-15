import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;


        for(int i=0; i<wires.length; i++){
            Set<Integer> set1=new HashSet<>();
            Set<Integer> set2=new HashSet<>();
            set1.add(wires[i][0]);
            set2.add(wires[i][1]);
            for(int k=0; k<n; k++) {
                for (int j = 0; j < i; j++) {
                    if (set1.contains(wires[j][0]) || set1.contains(wires[j][1])) {
                        set1.add(wires[j][1]);
                        set1.add(wires[j][0]);
                    }
                }
                for (int j = i + 1; j < wires.length; j++) {
                    if (set1.contains(wires[j][0]) || set1.contains(wires[j][1])) {
                        set1.add(wires[j][1]);
                        set1.add(wires[j][0]);
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (set2.contains(wires[j][0]) || set2.contains(wires[j][1])) {
                        set2.add(wires[j][1]);
                        set2.add(wires[j][0]);
                    }
                }
                for (int h = i + 1; h < wires.length; h++) {
                    if (set2.contains(wires[h][0]) || set2.contains(wires[h][1])) {
                        set2.add(wires[h][1]);
                        set2.add(wires[h][0]);
                    }
                }
            }
            int diff=(set1.size()-set2.size()<0)?set2.size()-set1.size():set1.size()-set2.size();
            answer= Math.min(diff, answer);
        }

        return answer;
    }
}