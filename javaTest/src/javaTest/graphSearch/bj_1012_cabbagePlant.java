package javaTest.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_1012_cabbagePlant {
	//public static ArrayList[] cabbagePlant ;// 배추밭 2차원 배열
	public static int[][] cabbagePlant ;// 배추밭 2차원 배열
	//public static ArrayList[] checkCabbagePlant ;// 탐색한 배추밭 2차원 배열
	public static int[][] checkCabbagePlant ;// 탐색한 배추밭 2차원 배열
	
	public static int rowSize;
	public static int colSize;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		// 테스트케이스가 여러개 나온다. 
		int testCaseNumber = Integer.parseInt(br.readLine());
		for(int k=0; k<testCaseNumber; k++) {
			// 첫번째 입력 줄 : 
			StringTokenizer st = new StringTokenizer(br.readLine());
			rowSize = Integer.parseInt( st.nextToken() );// 배추밭의 가로 길이
			colSize = Integer.parseInt( st.nextToken() );// 배추밭의 세로 길이
			int cabbagePlantSize = Integer.parseInt( st.nextToken()); // 배추가 심어져있는 위치의 개수 
			
			// 배추밭 2차원 배열 초기화 
			cabbagePlant = new int [rowSize][colSize];
			checkCabbagePlant = new int [rowSize][colSize];
			
			// 배추가 있는 위치는 배추밭 값을 1로 변경
			for(int i=0; i<cabbagePlantSize; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt( st.nextToken() );
				int y = Integer.parseInt( st.nextToken() );
				cabbagePlant[x][y] = 1;
			}
			
			// 배추밭 입력 값 확인을 위한 출력
			/*for(int i=0; i<cabbagePlant.length; i++) {
				for(int j=0; j<cabbagePlant[i].length; j++) {
					System.out.print(cabbagePlant[i][j] + " ");
				}
				System.out.println();
			}
			*/
			int depth = 0;
			int cnt =0;
		
			for(int i=0; i<rowSize; i++) {
				for(int j=0; j<colSize; j++) {
					if(cabbagePlant[i][j] == 1 && checkCabbagePlant[i][j] == 0) {
						dfs(depth, i, j);
						cnt = cnt+1;
					}
				}
			}
		
		
			// 배추밭 탐색한 위치 확인을 위한 출력
			/*for(int i=0; i<checkCabbagePlant.length; i++) {
				for(int j=0; j<checkCabbagePlant[i].length; j++) {
					System.out.print(checkCabbagePlant[i][j] + " ");
				}
				System.out.println();
			}
			*/
			sb.append(cnt).append("\n");
	
		}
		System.out.println(sb);
	}
	public static void dfs(int depth, int x, int y) {
		if(depth == rowSize * colSize) {
			return ;
		}
		checkCabbagePlant[x][y] = 1;
		//System.out.println("depth : " + depth);
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if( nx >= 0 && nx <rowSize && ny >= 0 && ny < colSize ) {
				if(cabbagePlant[nx][ny] == 1 && checkCabbagePlant[nx][ny] == 0) {
					dfs(depth+1, nx, ny);
				}
			}
		}
		return ;
	}
}
