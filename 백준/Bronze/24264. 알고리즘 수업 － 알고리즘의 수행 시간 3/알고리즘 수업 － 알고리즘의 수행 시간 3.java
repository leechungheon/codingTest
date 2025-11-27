import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long N = Integer.parseInt(br.readLine());
		sb.append(N*N).append("\n").append("2");
		System.out.println(sb);
	}
}
