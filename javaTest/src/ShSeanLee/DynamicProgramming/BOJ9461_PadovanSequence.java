package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461_PadovanSequence {
    public static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 0; i < numberOfCases; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(padovan(N)).append("\n");
        }
        System.out.println(sb);

    }

    // 점화식 P(n+1) = P(n-1) + P(n-2)
    public static long padovan(int n) {
        if(dp[n] == 0){
            dp[n] = padovan(n - 2) + padovan(n - 3);
        }
        return dp[n];
    }
}
