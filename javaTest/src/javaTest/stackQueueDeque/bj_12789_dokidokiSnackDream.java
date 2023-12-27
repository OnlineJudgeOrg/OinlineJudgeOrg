package javaTest.stackQueueDeque;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
 * 백준 12789번, 도키도키 간식드리미
 * 
 * 16% 틀렸습니다.
 * 
 * 
 */
public class bj_12789_dokidokiSnackDream {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		String[] numbers = br.readLine().split(" ");
		int expectedNumber = 1;
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0; i<num; i++) {
			int currentNumber = Integer.parseInt(numbers[i]);
			if (expectedNumber == currentNumber ) {
				expectedNumber++;
			}else {
				if ( !deque.isEmpty() && expectedNumber == deque.peek()) {
					deque.pop();
					expectedNumber++;
				}else {
					deque.push(currentNumber);
				}
			}
		}
		while(!deque.isEmpty()) {
			int nextNumber = deque.peek();
			if(expectedNumber == nextNumber ) {
				deque.pop();
				expectedNumber++;
			}else {
				System.out.println("Sad");
				System.exit(0);
			}
		}
		System.out.println("Nice");
		
	}
}
