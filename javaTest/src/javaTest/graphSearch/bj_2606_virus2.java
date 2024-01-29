package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2606_virus2 {
	public static ArrayList<Integer>[] computerArray ;
	public static boolean[] checkComputerArray;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberOfComputer = Integer.parseInt(br.readLine());
		int numberOfLink = Integer.parseInt(br.readLine());
		
		computerArray = new ArrayList[numberOfComputer+1];
		checkComputerArray = new boolean[numberOfComputer+1];
		
		for(int i=0; i<numberOfComputer+1; i++) {
			computerArray[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=0; i<numberOfLink; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			computerArray[tmp1].add(tmp2);
			computerArray[tmp2].add(tmp1);
		}
		
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		deque.addLast(1);
		
		int result = bfs(deque);
		// 1을 제외하고 감염되는 컴퓨터의 수
		System.out.println(result-1);
		
	}
	public static int bfs(ArrayDeque<Integer> deque) {
		int cnt = 0;
		
		while(!deque.isEmpty()) {
			int popIdx = deque.pollFirst();
			
			if(!checkComputerArray[popIdx]) {
//				System.out.println("popIdx : " + popIdx);
				cnt++;
				for(int i=0; i<computerArray[popIdx].size(); i++) {
					deque.addLast(computerArray[popIdx].get(i));
					
				}
				checkComputerArray[popIdx] = true;
			}
			
		}
		
		return cnt;
	}
}
