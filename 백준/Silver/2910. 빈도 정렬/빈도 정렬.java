import java.util.*;
import java.io.*;
class Number implements Comparable<Number>{
	int num;
	int count;
	int time;
	public Number(int num, int count, int time) {
		this.num=num;
		this.count=count;
		this.time=time;
	}
	
	@Override
	public int compareTo(Number other) {
		if(this.count==other.count) {
			return this.time-other.time;
		}else {
			return other.count-this.count;
		}
	}
}
class Main
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Number> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	boolean exist = false;
        	int num = Integer.parseInt(st2.nextToken());
        	for(Number n : list) {
        		if(n.num==num) {
        			exist=true;
        			n.count++;
        			break;
        		}
        	}
        	if(!exist) {
    			list.add(new Number(num,1,i));
    		}
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
        	Number num = list.get(i);
        	for(int j=0; j<num.count; j++) {
        		System.out.print(num.num+" ");
        	}
        }
	}
}