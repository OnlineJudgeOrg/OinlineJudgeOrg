package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2579_stairWalker {
	
//	public static int[] dp = new int[10001];
	public static ArrayList<Integer> dp = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시작점은 도착점까지 가면서 얻을 수 있는 총 점수의 최댓값 구하기
		// 한 계단을 밟으면서 다음 계단이나, 다음 계단으로 오를 수 있다. 
		// 
		int stairNumber = Integer.parseInt(br.readLine());
		
		// Integer 선언 안해주면 반환 값이 Object로 나옴.
//		ArrayList stairArray = new ArrayList<Integer>();
		ArrayList<Integer> stairArray = new ArrayList<Integer>();
		
		for(int i=0; i<stairNumber; i++) {
			int stairScore = Integer.parseInt(br.readLine());
			stairArray.add(stairScore);
		}
//		System.out.println(stairArray);
		
		// 마지막 계단을 꼭 밟아야 하기 때문에, reverse 시킨다.
		Collections.reverse(stairArray);
//		System.out.println(stairArray);
		
		// dp 계산
		dp.add(stairArray.get(0));
		for(int i=1; i<stairNumber; i=i+2) {
			int compNumber1; // 첫번째 계단의 값 넣을 변수
			int compNumber2; // 두번째 계단의 값 넣을 변수
			int lastIdx = dp.size() - 1; // dp 배열 마지막 인덱스 
		    int lastElement = dp.get(lastIdx); // dp 배열 마지막 값 
			
			if(i < stairNumber) {
				compNumber1 = lastElement + stairArray.get(i); // 1번째 계단
			}else {
				compNumber1 = 0;
			}
			if(i+1 < stairNumber ) {
				compNumber2 = lastElement + stairArray.get(i+1); // 2번째 계단
			}else {
				compNumber2 = 0;
			}
			
//			System.out.println("i : " + i);
//			System.out.println("lastElement : " + lastElement);
//			System.out.println("stairArray.get(i+1) : " + stairArray.get(i));
//			System.out.println("stairArray.get(i+2) : " + stairArray.get(i+1));
//			System.out.println("compNumber1 : " + compNumber1);
//			System.out.println("compNumber2 : " + compNumber2);
			
			dp.add(Math.max(compNumber1, compNumber2));
		}
		
		/*
		for(int i=0; i<dp.size(); i++) {
				System.out.println(dp.get(i));
		}
		*/
		System.out.println(dp.get(dp.size()-1));
		
	}
}
