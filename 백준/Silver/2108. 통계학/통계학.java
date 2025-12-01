import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1. 수의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		// 2. 숫자의 정보 입력
		int[] numbers = new int[N];
		
		int total=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		int maxCount = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			numbers[i]=Integer.parseInt(br.readLine());
			
			total+=numbers[i];
			max=Math.max(max, numbers[i]);
			min=Math.min(min, numbers[i]);
			list.add(numbers[i]);
			
			// 최빈값 구하기
			int data = map.getOrDefault(numbers[i], 0);
			map.put(numbers[i], data+1);
			if(data+1>maxCount) {
				maxCount=data+1;
			}
		}
		List<Integer> maxCountList = new ArrayList<>();
		for(Integer key : map.keySet()) {
			if(map.get(key)==maxCount) {
				maxCountList.add(key);
			}
		}
		Collections.sort(maxCountList);
		int answer1 = (int)Math.round((double)total/N); // 1st answer
		Collections.sort(list);
		int center = list.size()/2;
		int answer2 = list.get(center); // 2nd answer
		int answer3=0;
		if(maxCountList.size()>=2) {
			answer3=maxCountList.get(1);
		}else {
			answer3=maxCountList.get(0);
		}
		
		int answer4 = 0;
		if(N!=1) answer4 = max-min; // 4th answer
		
		sb.append(answer1).append("\n").append(answer2).append("\n").append(answer3).append("\n").append(answer4).append("\n");
		System.out.println(sb);
	}
}