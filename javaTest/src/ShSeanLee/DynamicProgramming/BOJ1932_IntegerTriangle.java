package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 풀이완료 (296ms)
// 합이 최대가 되는 경로에 있는 수의 합을 출력 -> dp

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
                if (j == 0) { // 0번째 열에 있는 값들은
                    dp[i][j] += dp[i - 1][j]; // 직전 행 0번째의 누적 합을 더하면 되고
                } else if (j == i){ // 마지막 열에 있는 값들은
                    dp[i][j] += dp[i - 1][j - 1]; // 직전행에 j-1번째의 누적합을 더하면 되고
                } else { // 중간에 있는 값들은
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]); // 직전행 j, j-1번째의 누적합 중 최댓값을 더해준다.
                }
            }
        }
        int max = 0; // 값이 마이너스가 나오지 않으므로 최솟값은 0이며,
        for (int i = 0; i < dp[triangleSize - 1].length; i++) { // 마지막 줄만 돌면 됨.
            max = Math.max(max, dp[triangleSize - 1][i]);
        }
        System.out.println(max);

    }
}
