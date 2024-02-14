package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2667_apartmentBlock {
	
	public static ArrayList<Integer>[] graph;
	public static ArrayList<Integer>[] checkGraph;
	public static int[] countArray;
//	public static int[][] graph;
	//public static ArrayList graph;
	public static int graphSize;
	public static int cnt;
	public static int depthCount;
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = { 0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2차원 배열 만들기 
		graphSize = Integer.parseInt(br.readLine());
		
		// graph 초기화
	//	graph = new int[graphSize][graphSize];
		graph = new ArrayList[graphSize];
		checkGraph = new ArrayList[graphSize];
		for(int i=0; i<graphSize; i++) {
			graph[i] = new ArrayList<Integer>();
			checkGraph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<graphSize; i++) {
			String inputLine  = br.readLine();
			for(int j=0; j<graphSize; j++) {
				//charAt(idx) char를 int로 변환하여 아스키코드로 반환한다. 
				// 숫자로 사용하기 위해서는 '0'을 빼준다. '0'은 아스키코드로 48
				//graph[i][j] = inputLine.charAt(j) - '0';
				graph[i].add(inputLine.charAt(j) - '0');
				checkGraph[i].add(0);
				//System.out.println("graph[i][j] : " + graph[i].get(j));
			}
		}
		
		// dfs 호출
		int depth = 0;
//		int x = 0;
//		int y = 0;
		cnt = 0;
		countArray = new int[graphSize*graphSize];
		
		for(int i=0; i<graphSize; i++) {
			for(int j=0; j<graphSize; j++) {
				if(checkGraph[i].get(j) == 0 && graph[i].get(j) == 1) {
					cnt++;
					depthCount = 0;
					checkGraph[i].set(j,cnt);
					dfs(depth, i, j, cnt);
				}
			}
		}
		
		// 최종 출력
		System.out.println(cnt);
		Arrays.sort(countArray);
		for(int i=0; i<countArray.length; i++) {
			if(countArray[i] > 0) {
				System.out.println(countArray[i]);
			}
		}
		
		/*
		for(int i=0; i<checkGraph.length; i++) {
			for(int j=0; j<checkGraph.length; j++) {
				System.out.print(checkGraph[i].get(j));
			}
			System.out.println();
		}
		*/
	}
	public static void dfs(int depth, int x, int y, int cnt) {
		if(depth == (graphSize*graphSize)) {
			return ;
		}
//		depthCount++;
//		if(cnt == (graphSize*graphSize)) {
//			return ;
//		}
		
		//depthCount++;
		countArray[cnt] = ++depthCount;
		/*
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		System.out.println("depth : " + depth);
		System.out.println("cnt : " + cnt);
		System.out.println("depthCount : " + depthCount);
		*/
		
		// 이동할 수 있는 장소 찾기 
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx<graphSize && ny>=0 && ny<graphSize) {
				// 탐색 여부 확인
				if(checkGraph[nx].get(ny) == 0 && graph[nx].get(ny) == 1) {
					checkGraph[nx].set(ny,cnt);
					dfs(depth+1, nx, ny, cnt);
				}
			}
		}
		return ;
	}
	
}
