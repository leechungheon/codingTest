import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 4, 3, 4, 5, 6};
        int[] result = sol.solution(prices);

        System.out.print("입력 배열: ");
        printArray(prices);
        System.out.print("결과 배열: ");
        printArray(result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}