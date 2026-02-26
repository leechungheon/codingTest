import java.util.*;
import java.io.*;
class Student implements Comparable<Student>{
	int id;
	int count;
	int time;
	public Student(int id, int count, int time) {
		this.id=id;
		this.count=count;
		this.time=time;
	}
	@Override
	public int compareTo(Student other) {
		if(this.count==other.count) {
			return this.time-other.time;
		}else {
			return this.count-other.count;
		}
	}
}
class Main
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Student> frame = new ArrayList<>();
		
		
		for(int i=0; i<cnt; i++) {
			int id = Integer.parseInt(st.nextToken());
			boolean exist = false;
			
			for(Student s : frame) {
				if(s.id==id) {
					exist=true;
					s.count++;
					break;
				}
			}
			
			if(!exist) {
				if(frame.size()>=n) {
					Collections.sort(frame);
					frame.remove(0);
				}
				frame.add(new Student(id,1,i));
			}
		}
		List<Integer> result = new ArrayList<>();
		
		for (Student s : frame) {
            result.add(s.id);
        }
        Collections.sort(result);

        for (int id : result) {
            sb.append(id).append(" ");
        }
        System.out.print(sb);
	}
}
