package javaTest.bruteforce;

import java.util.*;
import java.io.*;

public class bj_2231{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String inputStr = br.readLine(); // 자릿수를 확인하기 위해 String으로 입력 받음.
        int num = Integer.parseInt(inputStr);
        
        int result = 0; // 답이 없을 경우 0을 출력
        
        for(int i=num; i>0; i--) {
        	String iStr = Integer.toString(i);
        	//System.out.println("iStr : " + iStr);
        	int constructedNum = constructorNumber(iStr);
        	//System.out.println("constructedNum : " + constructedNum);
        	if(constructedNum == num) {
        		result = i;
        	}
        }
    	
    	System.out.println(result);
    	
    }
    public static int constructorNumber(String inputStr) {
    	int length = inputStr.length(); // 한자리씩 확인하기 위해 10의 n승 값을 구한다.
    	
    	int n = Integer.parseInt(inputStr);
    	
    	int constructedNum = n;
    	
    	for(int i=length; i>0; i--) {
    		
    		int index = i-1;
    		int divisor = (int) Math.pow(10, index);
    		//System.out.println("div  : " + n/div);
    		constructedNum += (n/divisor);
    		n = n%divisor;
    		//System.out.println("constructor  : " + constructor);
    	}
    	return constructedNum;
    }
}

