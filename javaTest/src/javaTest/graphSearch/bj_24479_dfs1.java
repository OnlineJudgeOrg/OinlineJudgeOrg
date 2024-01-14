package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_24479_dfs1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int vertexNumber =Integer.parseInt(st.nextToken());
		int edgeNumber =Integer.parseInt(st.nextToken());
		int startNumber =Integer.parseInt(st.nextToken());
		
		// 정점 배열 초기화
		ArrayList<Integer>[] vertexArray = new ArrayList[vertexNumber+1];
		for(int i=0; i<vertexNumber; i++) {
			vertexArray[i] = new ArrayList<Integer>();
		}
		
		int[] vertexChecked = new int[vertexNumber + 1];
		
		// 간선 입력 받기
		for(int i=0; i<edgeNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startEdge = Integer.parseInt(st.nextToken());
			int endEdge = Integer.parseInt(st.nextToken());
			
			vertexArray[startEdge].add(endEdge);
			vertexArray[endEdge].add(startEdge);
			
			// 정렬 추가(오름차순)
            Collections.sort(vertexArray[startEdge]);
            Collections.sort(vertexArray[endEdge]);
		}
		
		for(int i=0; i<=vertexNumber; i++) {
			System.out.println(vertexArray[i]);
		}
		
		int cnt = 1;
		// 이제부터 dfs() 시작한다.
		dfs(vertexArray, startNumber, vertexChecked, cnt);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<vertexChecked.length; i++) {
			sb.append(vertexChecked[i]).append("\n");
		}
		System.out.println(sb);
		

	}
	
	public static void dfs(ArrayList<Integer>[] vertexArray ,int startNumber, int[] vertexChecked, int cnt) {
		vertexChecked[startNumber] = cnt;
		
		for(int i=0; i<vertexArray[startNumber].size(); i++) {
			int nextVertex = vertexArray[startNumber].get(i);
			if(vertexChecked[nextVertex] == 0) {
				cnt++;
				dfs(vertexArray ,nextVertex, vertexChecked, cnt);
			}
		}
	}
}
