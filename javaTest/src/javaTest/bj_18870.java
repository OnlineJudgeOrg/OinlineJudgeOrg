package javaTest;

import java.util.*;
import java.io.*;
import java.sql.Array;

/*
 * 18870번 좌표압축
 */
public class bj_18870{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	String[] inputs = br.readLine().split(" ");
    	String[] copiedInputs = Arrays.copyOf(inputs, inputs.length);
    			
    	Arrays.sort(copiedInputs);
    	for(String s : inputs) {
    		//System.out.println("s : " + s);
    		int idx = Arrays.asList(copiedInputs).indexOf(s);
    		System.out.print(idx + " ");
    	}
    	
    }
}

