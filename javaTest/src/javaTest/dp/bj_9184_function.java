package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모이제이션은 재귀의 반복 숫자를 줄여주는 것이 결론적으로 메모이제이션 기법이고 동적계획법 문제에 자주 등장한다.
public class bj_9184_function {

	static StringBuilder sb = new StringBuilder();
	static int[][][] me = new int[21][21][21];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// a <= 0 or b<= 0 or c <= 0, then w(a,b,c) returns : 1
		
		// a > 20 or b > 20 or c > 20, then w(a,b,c) returns : w(20,20,20)
		
		// a < b and b < c then w(a,b,c) returns: w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c)
		
		// otherwise it returns : w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a==-1 && b==-1 && c==-1)break;
			
			int n = 0;
			n += w_function(a,b,c);
			
			sb.append("w(").append(a).append(", ")
			.append(b).append(", ").append(c)
			.append(") = ").append(n).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	public static int w_function(int a, int b, int c) {
		// 0~20 사이인 경우, [a][b][c] 값이 존재하면 메모이제이션 반환
		if(a>=0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20 && me[a][b][c]!=0) {
			return me[a][b][c];
		}
		// 종료 조건에 가깝다고 생각한다.
		if(a <=0 || b<=0 || c<=0) {
			return 1;
		}
		// 20이상인 경우, 모든 값이 동일하게 (20,20,20)으로 반환한다. 
		// 20,20,20을 호출하면 다시 첫번째 if문에 걸리게 되며 me[20][20][20]에 값을 넣는다. 
		if (a>20 || b>20 || c>20) {
			return me[20][20][20] = w_function(20,20,20);
		}
		//
		if(a<b&&b<c) {
			return me[a][b][c] = w_function(a,b,c-1) + w_function(a,b-1,c-1) - w_function(a, b-1, c);
			
		}
		// 아무조건에 걸리지 않으면 
		return me[a][b][c] = w_function(a-1, b, c) + w_function(a-1, b-1, c)+
				w_function(a-1, b, c-1) - w_function(a-1, b-1, c-1);
	}

}
