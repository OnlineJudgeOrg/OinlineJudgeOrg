package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1260_bfsAndDfs {
	public static ArrayList<Integer>[] graph;
	public static int[] bfsVisited;
	public static int[] dfsVisited;
	public static int numberOfNode;
	public static int numberOfLink;
	public static int startNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		numberOfNode = Integer.parseInt(st.nextToken());
		numberOfLink = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(st.nextToken());
		
		// node 배열 초기화
		graph = new ArrayList[numberOfNode+1];
		bfsVisited = new int[numberOfNode+1];
		dfsVisited = new int[numberOfNode+1];
		
		for(int i=0; i<numberOfNode+1; i++) {
			graph[i] = new ArrayList<Integer>();
			bfsVisited[i] = 0;
			dfsVisited[i] = 0;
		}
		
		for(int i=0; i<numberOfLink; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			graph[tmp1].add(tmp2);
			graph[tmp2].add(tmp1);
			
		}
		
		int depth = 0;
		int idx = startNode;
		int cnt = 1;
		dfs(depth, idx, cnt);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<dfsVisited.length; i++) {
			sb.append(dfsVisited[i]).append(" ");
		}
		System.out.println(sb);
		
		bfs(graph);
	}
	public static void bfs(ArrayList<Integer>[] graph) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		int bfsCnt = 1;
		deque.addLast(startNode);
		
		while(!deque.isEmpty()) {
			int popDeque = deque.pollFirst();
			if(bfsVisited[popDeque] <= 0) {
				bfsVisited[popDeque] = bfsCnt++;
				for(int i=0; i<graph[popDeque].size(); i++) {
					deque.addLast(graph[popDeque].get(i));
				}
			}
		}
		
		// bfs 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<bfsVisited.length; i++) {
			sb.append(bfsVisited[i]).append(" ");
		}
		System.out.println(sb);
		
	}
	public static void dfs(int depth, int idx, int cnt) {
		if(depth == numberOfNode) {
			
			return ;
		}
		
		if(dfsVisited[idx] <= 0) {
			dfsVisited[idx] = cnt;
			for(int i=0; i<graph[idx].size(); i++) {
				dfs(depth+1, graph[idx].get(i), cnt+1 );
			}
		}
		return ;
	}
	
}
