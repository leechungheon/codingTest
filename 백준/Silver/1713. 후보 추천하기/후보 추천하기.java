import java.util.*;
import java.io.*;

import java.util.*;

class Student implements Comparable<Student> {
    int id;
    int count; // 추천수
    int time;  // 게시된 시간

    public Student(int id, int count, int time) {
        this.id = id;
        this.count = count;
        this.time = time;
    }

    // 사진틀 내에서 삭제 우선순위를 정하는 기준
    @Override
    public int compareTo(Student o) {
        if (this.count == o.count) {
            return this.time - o.time; // 추천수가 같으면 시간순 (오름차순 = 오래된 것부터)
        }
        return this.count - o.count; // 추천수순 (오름차순 = 적은 것부터)
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사진틀 개수
        int total = sc.nextInt(); // 총 추천 횟수
        List<Student> frame = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int studentId = sc.nextInt();
            boolean exists = false;

            // 1. 이미 사진틀에 있는지 확인
            for (Student s : frame) {
                if (s.id == studentId) {
                    s.count++;
                    exists = true;
                    break;
                }
            }

            // 2. 사진틀에 없는 경우
            if (!exists) {
                if (frame.size() >= N) {
                    // 추천수 적은 순 -> 오래된 순으로 정렬 후 첫 번째 요소 삭제
                    Collections.sort(frame);
                    frame.remove(0);
                }
                // 새 학생 추가 (현재 루프의 i를 시간으로 사용)
                frame.add(new Student(studentId, 1, i));
            }
        }

        // 최종 출력: 학번 기준 오름차순 정렬
        List<Integer> result = new ArrayList<>();
        for (Student s : frame) {
            result.add(s.id);
        }
        Collections.sort(result);

        for (int id : result) {
            System.out.print(id + " ");
        }
    }
}
