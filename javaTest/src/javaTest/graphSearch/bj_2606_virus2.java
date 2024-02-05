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
	
	public static int numberOfComputer;
	public static int cnt = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		numberOfComputer = Integer.parseInt(br.readLine());
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

		int depth = 0;
		int idx = 1;
		checkComputerArray[1] = true;
		
		dfs(depth, idx);
		// 1을 제외하고 감염되는 컴퓨터의 수
		System.out.println(cnt);
	}
	private static void dfs(int depth, int idx) {
		if(depth == numberOfComputer) {
			return;
		}
		// 탐색할 수 있는 모든 조합
		for(int i=0; i<computerArray[idx].size(); i++) {
			int tmp = computerArray[idx].get(i);
			
			if(checkComputerArray[tmp] == false) {
				checkComputerArray[tmp] = true;
				dfs(depth+1, tmp);
//				checkComputerArray[tmp] = false;
				cnt++;
			}
		}
		
		return;
	}
	
}

