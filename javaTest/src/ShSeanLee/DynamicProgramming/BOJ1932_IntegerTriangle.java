package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1932_IntegerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int triangleSize = Integer.parseInt(br.readLine());
        int[][] dp= new int[triangleSize][triangleSize];
//        ArrayList<Integer>[] dp = new ArrayList[triangeSize];
        for (int i = 0; i < triangleSize; i++) {
//            dp[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
//                dp[i].add(Integer.parseInt(st.nextToken()));
            }
//            System.out.println(dp[i].toString());
        }

        for (int i = 1; i < triangleSize; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i){
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp[triangleSize - 1].length; i++) {
            max = Math.max(max, dp[triangleSize - 1][i]);
        }
        System.out.println(max);

    }
}
