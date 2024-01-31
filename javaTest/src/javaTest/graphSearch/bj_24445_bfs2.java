package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

//token update
public class bj_24445_bfs2 {
	
	public static ArrayList<Integer>[] array;
	public static int[] checkArray;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int nodeNumber = Integer.parseInt(st.nextToken());
		int linkNumber = Integer.parseInt(st.nextToken());
		int startNodeNumber = Integer.parseInt(st.nextToken());
		
		array = new ArrayList[nodeNumber+1];
		checkArray = new int[nodeNumber+1];
		
		for(int i=0; i<nodeNumber+1; i++) {
			array[i] = new ArrayList<Integer>();
			checkArray[i] = 0;
		}
		
		for(int i=0; i<linkNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
//			while(st.hasMoreTokens()) {
//			}
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			array[tmp1].add(tmp2);
			array[tmp2].add(tmp1);
		}
		
		for(int i=0; i<array.length; i++) {
			Collections.sort(array[i], Comparator.reverseOrder());
		}
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		queue.addLast(startNodeNumber);
		
		bfs(queue);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<checkArray.length; i++) {
			sb.append(checkArray[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void bfs(Deque<Integer> queue) {
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int findNodeNumber = queue.pollFirst();
			
			if(checkArray[findNodeNumber] == 0) {
				checkArray[findNodeNumber] = cnt++;
				for(int i=0; i<array[findNodeNumber].size(); i++) {
					queue.addLast(array[findNodeNumber].get(i));
				}
			}
		}
	}
}
