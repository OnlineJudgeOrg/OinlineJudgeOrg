package javaTest.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 11478번 서로 다른 부분 문자열의 개수
 * 중복제거하는 HashSet을 사용한다. 
 * 글자수를 증가하며 HashSet에 넣는다.
 * 2중 for문이 돌겠지만 1000이하 이기 때문에 
 * 1000000이라 가능할듯?
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 
 */
public class bj_11478_DistinctSubstrings{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	// 중복제거를 위해 Set을 사용
    	HashSet<String> hSet = new HashSet<String>();
    	
    	//단어 길이
    	for(int i=1; i<s.length(); i++) {
    		//단어는 한글자씩 옆으로 이동하기 때문에 j++로 설정
    		for(int j=0; j+i <=s.length(); j++) {
				String tmp = s.substring(j, j+i);
				hSet.add(tmp);
    		}
    	}
    	
    	System.out.println(hSet);
    	
    }
}

