package DynamicProgramming;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BOJ2579_Stairs {
//    public static int[] dp;
//    public static int[] scores;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numberOfStairs = Integer.parseInt(br.readLine());
//        scores = new int[numberOfStairs];
//        dp = new int[numberOfStairs + 1];
//
//        for (int i = 0; i < numberOfStairs; i++) {
//            scores[i] = Integer.parseInt(br.readLine());
//        }
//        dp[0] = 0;
//        dp[1] = scores[1];
//        System.out.println(recursive(numberOfStairs));
//
//
//
//
//    }
//
//    public static int recursive(int n) {
//        return dp[n] = Math.min(recursive(dp[n - 1]), recursive(dp[n - 2])) + scores[n];
//    }
//
//}

// 정답
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2579_Stairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N + 1];
        int[] arr = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // index = 0 은 시작점이다.
        DP[1] = arr[1];

        // N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
        if (N >= 2) {
            DP[2] = arr[1] + arr[2]; // 둘다 밟는게 최대니 max를 할 필요 없음
        }

        // DP[0]을 안하는 이유는 어차피 초기화된 값인 0이므로

        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
        }

//        score[1] = stair[1];
//        score[2] = stair[1] + stair[2];
//        score[3] = Math.max(stair[1], stair[2]) + stair[3];
//
//        for (int n = 4; n <= N; n++) {
//            score[n] = Math.max(score[n - 3] + stair[n - 1], score[n - 2]) + stair[n];
//        }


        System.out.println(DP[N]);

    }

}
