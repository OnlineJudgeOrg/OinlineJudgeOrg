package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2579_stairWalker2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairNumber = Integer.parseInt(br.readLine());

        int[] stairArray = new int[stairNumber + 1]; // 0번 인덱스는 사용하지 않음
        int[] dp = new int[stairNumber + 1];

        for (int i = 1; i <= stairNumber; i++) {
            stairArray[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairArray[1];
        if (stairNumber >= 2) {
            dp[2] = stairArray[1] + stairArray[2];
        }

        for (int i = 3; i <= stairNumber; i++) {
            int compNumber1 = dp[i - 2] + stairArray[i];
            int compNumber2 = dp[i - 3] + stairArray[i - 1] + stairArray[i];

            dp[i] = Math.max(compNumber1, compNumber2);
        }

        System.out.println(dp[stairNumber]);
    }
}
