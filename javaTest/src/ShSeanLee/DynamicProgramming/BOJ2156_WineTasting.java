package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156_WineTasting {
    public static int glassesOfWine;
    public static int[] amountOfWine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        glassesOfWine = Integer.parseInt(br.readLine());
        amountOfWine = new int[glassesOfWine + 1];
        for (int i = 1; i <= glassesOfWine; i++) {
            amountOfWine[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[glassesOfWine + 1];
//        dp[0] = amountOfWine[0];
        dp[1] = amountOfWine[1];

        if (glassesOfWine >= 2) {
            dp[2] = amountOfWine[1] + amountOfWine[2];
        }

        for (int i = 3; i < glassesOfWine + 1; i++) {
            // n번째 와인을 먹는 방법은 1) [n - 2], 2) [n - 3] + [n - 1]
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + amountOfWine[i - 1]) + amountOfWine[i]) ;
        }

        int result = dp[0];
        for (int i = 1; i < glassesOfWine + 1; i++) {
            result = Math.max(result, dp[i]);
//            System.out.println(dp[i]);
        }
        System.out.println(result);



    }




}
