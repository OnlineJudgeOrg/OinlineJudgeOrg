package DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844_StairNumberEZ {
    public static int[] dp;
    public static int stairNumbers;
    public static int lengthOfNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lengthOfNumber = Integer.parseInt(br.readLine());
        stairNumbers = 0;
        for (int i = 0; i < 9; i++) {
            dp = new int[lengthOfNumber];
            dp[0] = i;
            recursive(1);
        }
        System.out.println(stairNumbers);
    }

    public static void recursive(int depth) {
        if (depth == lengthOfNumber){
            stairNumbers++;
        } else {
            // 직전 수의 세가지 케이스 - 0인경우, 9인경우, 1 ~ 8인 경우
            if (dp[depth - 1] == 0) { // case 1: 0인 경우
                dp[depth] = dp[depth - 1] + 1;
                recursive(depth + 1);
            } else if (dp[depth] == 9) { // case 2: 9인 경우
                dp[depth] = dp[depth - 1] - 1;
                recursive( depth + 1);
            } else { // case 3:  그 외
                dp[depth] = dp[depth - 1] + 1;
                recursive(depth + 1);
                dp[depth] = dp[depth - 1] - 1;
                recursive(depth + 1);
            }
        }
    }
}
