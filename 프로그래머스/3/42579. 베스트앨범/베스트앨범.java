import java.util.*;
// 노래 정보를 담기 위한 별도의 클래스
class Song {
    int id;
    int plays;

    public Song(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>(); // ArrayList 사용
        Map<String, Integer> totalPlaysGenres = new HashMap<>();
        //1. 장르 별 플레이횟수 총합 계산
        for(int i=0; i<genres.length; i++){
            if(totalPlaysGenres.containsKey(genres[i])){
                int currentPlays=plays[i]+totalPlaysGenres.get(genres[i]);
                totalPlaysGenres.put(genres[i],currentPlays);
            }else{
                totalPlaysGenres.put(genres[i],plays[i]);
            }
        }
        // 2. 총 재생 횟수를 기준으로 장르를 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(totalPlaysGenres.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 3. 각 장르 내에서 노래를 정렬하고 베스트 앨범에 추가
        for (Map.Entry<String, Integer> entry : entryList) {
            String currentGenre = entry.getKey();

            // 현재 장르에 속한 노래들을 담을 리스트 생성
            List<Song> songList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(currentGenre)) {
                    songList.add(new Song(i, plays[i]));
                }
            }

            // 장르 내 노래들을 정렬 (1. 재생수 내림차순, 2. 고유번호 오름차순)
            songList.sort((s1, s2) -> {
                if (s1.plays != s2.plays) {
                    return s2.plays - s1.plays;
                }
                return s1.id - s2.id;
            });

            // 가장 많이 재생된 노래 1개 추가
            answerList.add(songList.get(0).id);

            // 노래가 2곡 이상이면 2번째 노래도 추가
            if (songList.size() > 1) {
                answerList.add(songList.get(1).id);
            }
        }

        System.out.println("Value를 기준으로 내림차순 정렬된 Key 목록:");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey());
        }
        //2. 장르 수 만큼 TreeMap 생성 후 map.add(재생수, 인덱스) 저장
        // ArrayList를 int[] 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "rap"};
        int[] plays = {500, 600, 150, 800, 2500, 3000};

        int[] result = solution.solution(genres, plays);

        // 결과 배열 출력 (현재 solution 메서드가 빈 배열을 반환하므로 결과는 비어있음)
        System.out.print("최종 결과: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}