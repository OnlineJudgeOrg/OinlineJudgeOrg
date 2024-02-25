package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ10844_StairNumberEZ_v2 {
    public static long[] dp;
    public static long[] tmp;
    public static long stairNumbers;
    public static int lengthOfNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lengthOfNumber = Integer.parseInt(br.readLine());
        stairNumbers = 0;
        dp = new long[10];
        tmp = new long[10];
        for (int i = 1; i < 10; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < lengthOfNumber - 1; i++) {
            counting();
        }


        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i]);
            stairNumbers += dp[i];
        }

        System.out.println(stairNumbers % 1000000000);
    }

    public static void counting () { // n번째 dp는 0~9까지 도달하는 방법의 수(마지막 자리수가 n이면 그 수 dp에 cnt++ 해줌)
        // 직전 수의 세가지 케이스 - 0인경우, 9인경우, 1 ~ 8인 경우
        for (int i = 0; i < 10; i++) {
            tmp[i] = dp[i];
        }
        dp[0] = tmp[1] % 1000000000;
        dp[9] = tmp[8] % 1000000000;
        for (int i = 1; i < 9; i++) {
            dp[i] = tmp[i - 1] % 1000000000 + tmp[i + 1] % 1000000000;
        }

    }

}
