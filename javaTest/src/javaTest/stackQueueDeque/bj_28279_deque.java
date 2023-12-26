package javaTest.stackQueueDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 백준 bj_28279_덱 2
 *
 * 
 * 2초 : 1억 연산 * 2 
 * 1024mb 
 * 	1  X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
	2  X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
	3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
	4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
	5: 덱에 들어있는 정수의 개수를 출력한다.
	6: 덱이 비어있으면 1, 아니면 0을 출력한다.
	7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
	8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 */
public class bj_28279_deque {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			switch(num) {
				case 1 :
					// 정수 x를 덱의 앞에 넣는다. 
					int x = Integer.parseInt(st.nextToken());
					deque.addFirst(x);
					break;
				case 2 : 
					int x2 = Integer.parseInt(st.nextToken());
					deque.addLast(x2);
					break;
				case 3 :
					sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
					break;
				case 4 : 
					sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
					break;
				case 5 :
					sb.append(deque.size()).append('\n');
					break;
				case 6 : 
					sb.append(deque.isEmpty() ? 1 : 0).append('\n');
					break;
				case 7 :
					sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
					break;
				case 8 : 
					sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}
}
