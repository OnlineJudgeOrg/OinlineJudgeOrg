package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 1620번 나는야 포켓몬 마스터 이다솜
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 
 */
public class bj_1620_PokemonMaster{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nm = br.readLine().split(" ");
    	int n = Integer.parseInt(nm[0]);
    	int m = Integer.parseInt(nm[1]);
    	
    	HashMap<String,Integer> pokemonName = new HashMap<String, Integer>();
    	HashMap<Integer,String> pokemonNumber = new HashMap<Integer, String>();
    	
    	for(int i=0; i<n; i++) {
    		String name = br.readLine();
    		pokemonName.put(name, i+1);
    		pokemonNumber.put(i+1, name);
    	}
    	System.out.println(pokemonName);
    	System.out.println(pokemonNumber );
    	StringBuilder sb = new StringBuilder();
    	
    	for(int j=0; j<m; j++) {
    		String input = br.readLine();
    		System.out.println("input : " + input);
    		
    		boolean isNumber = isNumber(input);
    		System.out.println("result : " + isNumber);
    		
    		if(isNumber) {// 숫자(포켓몬 번호)인 경우 
    			pokemonNumber.get(input);
    			sb.append(pokemonNumber.get(input)).append("\n");
    		}else {// 문자(포켓몬 이름)인 경우 
    			pokemonName.get(input);
    			sb.append(pokemonName.get(input)).append("\n");
    		}
    		System.out.println(sb);
    		
    		
    	}
    }
    public static boolean isNumber(String input) {
    	boolean result = false;
    	
    	for(int k=0; k<input.length(); k++) {
			char tmp = input.charAt(k);
			result = Character.isDigit(tmp);
		}
    	return result;
    }
}

