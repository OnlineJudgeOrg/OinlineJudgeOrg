package javaTest.bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// git test song 
		// git test2 song
		// git test3 song
		// git test4 sh
		int cnt = 0; // 666이 포함된 숫자 
		String target_str = "666";
		int target_int = Integer.parseInt(target_str);
		//int i = 0;
		int result = 0;
		
		//System.out.println("n : " + n );
		//System.out.println("cnt : " + cnt );
		while(cnt != n) {
			//System.out.println("loop : " + i);
			if(target_str.contains("666")) {
				//System.out.println("cnt 증가 **");
				cnt++;
				//System.out.println("target_str : " + target_str);
				//System.out.println("target_int : " + target_int);
				result = target_int;
				
			}
			if(cnt == n) {
				break;
			}
			target_int = target_int+1;
			target_str = String.valueOf(target_int);
			//i++;
		}
		System.out.println(target_int);

	}

}

