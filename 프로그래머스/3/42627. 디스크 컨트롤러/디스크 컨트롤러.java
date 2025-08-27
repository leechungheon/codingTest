import java.util.*;

class Disk implements Comparable<Disk>{
    int index;
    int requestTime;
    int processingTime;

    public Disk(int index, int requestTime, int processingTime) {
        this.index = index;
        this.requestTime = requestTime;
        this.processingTime = processingTime;
    }
    @Override
    public int compareTo(Disk o) {
            return this.processingTime - o.processingTime;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        //전체 작업을 요청시간에 따라 먼저 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        int answer = 0; //반환 시각의 누적 합
        int count=0;
        int jobIndex = 0;
        int currentTime = 0;
        PriorityQueue<Disk> diskWatingList= new PriorityQueue<>();

        //처리할 작업이 남아있다면 반복
        while(count<jobs.length){
            ///현재 시각 이전에 요청작업 들어온 것 큐에 저장
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime){
                diskWatingList.add(new Disk(jobIndex,jobs[jobIndex][0],jobs[jobIndex][1]));
                jobIndex++;
            }
            if (!diskWatingList.isEmpty()) {
                //현재 디스크 처리
                Disk currentDisk = diskWatingList.poll();
                currentTime+= currentDisk.processingTime;
                answer +=currentTime-currentDisk.requestTime;
                count++;
            }else{
                currentTime=jobs[jobIndex][0];
            }
        }

        return answer/jobs.length;
    }
}