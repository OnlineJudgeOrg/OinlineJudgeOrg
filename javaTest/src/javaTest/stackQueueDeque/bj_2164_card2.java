package javaTest.stackQueueDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 백준 2164_카드2
 * 1부터 n까지 반복하며 배수의 boolean 값 변경 
 * 
 * 2초 : 1억 연산 * 2 
 * 128mb 
 * 
 * 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 
 * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 
 */
public class bj_2164_card2 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1; i<n+1; i++) {
			deque.addLast(i);
		}
		//System.out.println(deque);
		
		while(deque.size() > 1) {
			// 가장 앞에 있는 숫자는 제거한다.
			deque.removeFirst();
			// 두번재 숫자는 큐에 다시 삽입한다.
			int downNumber = deque.poll();
			deque.addLast(downNumber);
		}
		
		System.out.println(deque.poll());
	}
}
