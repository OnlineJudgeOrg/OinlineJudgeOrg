package javaTest.bruteforce;

import java.util.*;
import java.io.*;

public class bj_19532{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] inputs = br.readLine().split(" ");
    	
    	int a = Integer.parseInt(inputs[0]);
    	int b = Integer.parseInt(inputs[1]);
    	int c = Integer.parseInt(inputs[2]);
    	int d = Integer.parseInt(inputs[3]);
    	int e = Integer.parseInt(inputs[4]);
    	int f = Integer.parseInt(inputs[5]);
    	
    	int y = ((c*d)-(a*f)) / ((b*d) - (a*e));
    	int x = ((c*e)-(b*f)) / ((a*e) - (b*d));
    	
    	System.out.println(x +" " + y);
    }
}

