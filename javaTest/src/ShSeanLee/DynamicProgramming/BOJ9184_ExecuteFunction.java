package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 1700~1800ms의 시간초가 나오는 원인 파악 필요 -> 같아보이는 다른 코드들은 300ms

public class BOJ9184_ExecuteFunction {
    public static int result = 0;
    public static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new int[51][51][51]; // 0~50, 마이너스는 결과값이 다 1이므로 담아둘 필요 없음
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 & c == -1) {
                break;
            } else {
                result = function1(a, b, c);
            }

            String tmp = String.format("w(%d, %d, %d) = %d", a, b, c, result);
//            System.out.println(tmp);
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);



    }

    public static int function1(int a, int b, int c) { // memorization을 활용한 풀이
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        } else if (a > 20 || b > 20 || c > 20) {
//            dp[a][b][c] = function1(20, 20, 20);
            return dp[20][20][20] = function1(20, 20, 20);
        } else if (a < b && b < c) {
            dp[a][b][c] = function1(a, b, c - 1) + function1(a, b - 1, c - 1) - function1(a, b - 1, c);
        } else {
            dp[a][b][c] = function1(a - 1, b, c) + function1(a - 1, b - 1, c) + function1(a - 1, b, c - 1) - function1(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }

}
