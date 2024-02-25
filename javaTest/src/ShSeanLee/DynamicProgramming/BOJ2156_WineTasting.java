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
        amountOfWine = new int[glassesOfWine];
        for (int i = 0; i < glassesOfWine; i++) {
            amountOfWine[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[glassesOfWine];
        dp[0] = amountOfWine[0];
        dp[1] = amountOfWine[1];

        for (int i = 2; i < glassesOfWine; i++) {
            // n번째 와인을 먹는 방법은 1) n - 2, 2) n - 1
            dp[i] = Math.max(dp[i - 2], dp[i - 1]) + amountOfWine[i];
        }
        for (int i = 0; i < glassesOfWine; i++) {
            System.out.println(dp[i]);
        }



    }




}
