import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        // 차량 번호와 입차 시간을 저장할 Map
        Map<String, String> carInTime = new HashMap<>();
        // 차량 번호와 총 주차 시간을 저장할 Map
        Map<String, Integer> carTotalTime = new TreeMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];
            
            if (action.equals("IN")) {
                // 입차 시점 기록
                carInTime.put(carNumber, time);
            } else if (action.equals("OUT")) {
                // 출차 시점에서 총 주차 시간 계산
                String inTime = carInTime.remove(carNumber);
                int totalMinutes = calculateTime(inTime, time); // 시간 차 계산
                carTotalTime.put(carNumber, carTotalTime.getOrDefault(carNumber, 0) + totalMinutes);
            }
        }
        
        // 출차하지 않은 차량 처리: 23:59에 출차한 것으로 간주
        for (String carNumber : carInTime.keySet()) {
            String inTime = carInTime.get(carNumber);
            int totalMinutes = calculateTime(inTime, "23:59");
            carTotalTime.put(carNumber, carTotalTime.getOrDefault(carNumber, 0) + totalMinutes);
        }

        // 차량별 요금 계산
        List<Integer> feesList = new ArrayList<>();
        for (String carNumber : carTotalTime.keySet()) {
            int totalMinutes = carTotalTime.get(carNumber);
            int fee = calculateFee(fees, totalMinutes);
            feesList.add(fee);
        }

        // 차량 번호 순으로 정렬하여 요금 반환
        answer = new int[feesList.size()];
        for (int i = 0; i < feesList.size(); i++) {
            answer[i] = feesList.get(i);
        }

        return answer;
    }

    // 시간을 분 단위로 계산하는 메서드
    private int calculateTime(String inTime, String outTime) {
        String[] inParts = inTime.split(":");
        String[] outParts = outTime.split(":");
        
        int inMinutes = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
        int outMinutes = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);
        
        return outMinutes - inMinutes;
    }

    // 요금 계산 메서드
    private int calculateFee(int[] fees, int totalMinutes) {
        if (totalMinutes <= fees[0]) {
            return fees[1]; // 기본 시간 이내라면 기본 요금
        }
        int extraMinutes = totalMinutes - fees[0];
        int extraFee = (int) Math.ceil((double) extraMinutes / fees[2]) * fees[3];
        return fees[1] + extraFee; // 기본 요금 + 추가 요금
    }
}
