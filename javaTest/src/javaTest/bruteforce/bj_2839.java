package javaTest;

import java.util.*;
import java.io.*;

public class bj_2839{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int target = Integer.parseInt(br.readLine());
    	int result = -1;
    	
    	
    	for(int i=0; i<target; i++) {
    		int n = target;
    		int sum = 0;
    		// 3의 배수를 빼주고, 3을 뺀 갯수를 센다.
    		int divisor = (i*3);
    		sum += i;
    		if(n-divisor > 0) { //양수의 경우는 5로 나눌 값이 있다는 것 
    			n -= divisor;
    		}else if( n - divisor == 0) {// 0인 경우는 3의 배수로 나누는 것이 최소값
    			result = i;
    			break;
    		}else { // 3로 나누기가 불가능한 수
    			result = -1;
    		}
    		// 5로 나눈 값과 3을 뺀 갯수를 더해서 최소 값을 구한다.
    		if(n%5 == 0) {
    			sum += n/5;
    			result = sum;
    			break;
    		}
    		
    	}
    	System.out.println(result);
    }
}

