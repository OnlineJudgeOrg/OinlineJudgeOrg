package DynamicProgramming;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1904_01Tile {
    public static int[] dp = new int[1000001]; // 1~ 1,000,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));
    }

    // 점화식 : a(n) = a(n-1) + a(n-2) -> 피보나치 수열
    public static int fibonacci(int n) { // 312ms
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 15746;
            return dp[n];
        }
    }

//    public static int fibonacci(int n) { // 114ms
//        dp[1] =1;
//        dp[2] =2;
//        for(int i=3; i<n+1; i++) {
//            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
//        }
//        return dp[n];
//    }



}
