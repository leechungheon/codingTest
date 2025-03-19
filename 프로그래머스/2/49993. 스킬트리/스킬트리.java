import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

            for(int j=0; j< skill_trees.length; j++) { //skill_trees 순회
                int[] array=new int[skill.length()];
                Arrays.fill(array, -1);
                for (int k = 0; k < skill_trees[j].length(); k++) { // skill_trees 요소 순회
                    for (int i = 0; i < skill.length(); i++) { //c,b,d
                        if (skill_trees[j].charAt(k) == skill.charAt(i)) {
                            array[i] = k;
                        }
                    }
                }
                boolean judge = true;
                for (int c = 1; c < array.length; c++) {
                    if (array[c] != -1 && array[c - 1] == -1) { // 이전 스킬이 없는데 현재 스킬이 있다면 잘못된 순서
                        judge = false;
                        break;
                    }
                    if (array[c] != -1 && array[c - 1] != -1 && array[c] < array[c - 1]) { // 올바른 순서인지 확인
                        judge = false;
                        break;
                    }
                }
                if (judge) answer++;
            }

        return answer;
    }
}