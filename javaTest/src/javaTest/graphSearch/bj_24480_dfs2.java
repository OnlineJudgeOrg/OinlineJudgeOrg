package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_24480_dfs2 {
	public static ArrayList<Integer>[] vertexList;
	public static int[] vertexCheck;
	public static int cnt = 1;
	public static int vertexNumber;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		vertexNumber = Integer.parseInt(st.nextToken());
		int edgeNumber = Integer.parseInt(st.nextToken());
		int startNumber = Integer.parseInt(st.nextToken());
		
		vertexList = new ArrayList[vertexNumber+1] ;
		vertexCheck = new int[vertexNumber+1];
		
		for(int i=0; i<vertexNumber+1; i++) {
			vertexList[i] = new ArrayList<Integer>();
			vertexCheck[i] = 0;
		}
		
		for(int i=0; i<edgeNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			
			vertexList[vertex1].add(vertex2);
			vertexList[vertex2].add(vertex1);
			
		}
		
		// 내림차순
		for(int i=0; i<vertexList.length; i++) {
			Collections.sort(vertexList[i], Collections.reverseOrder());
		}
		
		vertexCheck[startNumber] = cnt++;
		
		int depth = 0;
		dfs(depth, startNumber);
		for(int i=1; i<vertexCheck.length; i++) {
			System.out.println(vertexCheck[i]);
		}
		
	}
	
	public static void dfs(int depth, int nodeIdx) {
		if(depth == vertexNumber) {
			return ;
		}
		
		for(int i=0; i<vertexList[nodeIdx].size(); i++) {
			int tmp = vertexList[nodeIdx].get(i);
			if(vertexCheck[tmp] <= 0 ) {
				vertexCheck[tmp] = cnt++;
				dfs(depth+1 ,tmp);
			}
		}
		return ;
	}
	
}
