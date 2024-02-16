package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_24444_bfs1 {
	public static ArrayList<Integer>[] nodeArray ;
	public static int[] checkNodeArray ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int nodeNumber = Integer.parseInt(st.nextToken());
		int linkNumber = Integer.parseInt(st.nextToken());
		int startNodeNumber = Integer.parseInt(st.nextToken());

		nodeArray = new ArrayList[nodeNumber+1];
		for(int i=0; i<nodeNumber+1; i++) {
			nodeArray[i] = new ArrayList<Integer>();
		}
		checkNodeArray = new int[nodeNumber+1];
		
		for(int i=0; i<linkNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node = Integer.parseInt(st.nextToken());
			int link = Integer.parseInt(st.nextToken());
			
			nodeArray[node].add(link);
			nodeArray[link].add(node);
			
		}
		
		for(int i=0; i<nodeArray.length; i++) {
			Collections.sort(nodeArray[i]);
		}
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.addLast(startNodeNumber);
		bfs(deque);
		
		
		// 시간초과 때문에 sb 사용
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<checkNodeArray.length; i++) {
			sb.append(checkNodeArray[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(Deque<Integer> deque) {
		// 
		int cnt = 1;
		
		// 큐가 존재하면 while문 반복
		while (!deque.isEmpty()) {
			// 큐에서 가장 앞에 있는 값을 뺀다. 
			int popNode = deque.pollFirst();
			
			// 해당 노드와 연결된 자식 노드중 탐색되지 않은 노드를 큐에 넣는다. 
			if(checkNodeArray[popNode] <= 0) {
				for(int i : nodeArray[popNode]) {
					deque.addLast(i);
				}
				// 탐색 완료 표시한다.
				checkNodeArray[popNode] = cnt;
				cnt++;
			}
			
		}
		return ;
	}
}
