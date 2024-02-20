package DynamicProgramming;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BOJ1463_MakingOne { // 실패
//    public static int numberOfCalculation;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//
//        // <1> 3으로 나누어 떨어지면 3으로 나눔.
//        // <2> 그렇지 않으면 2로 나누어 떨어지는지 확인
//        // <3> 그렇지 않으면, -1
//        numberOfCalculation = Integer.MAX_VALUE;
//
//        System.out.println(calculation(N, 1));
//
//
//
//    }
//
//    public static int calculation(int X, int tmp){
//        if (X == 1){
//            numberOfCalculation = Math.min(numberOfCalculation,tmp);
//            return numberOfCalculation;
//        } else {
//            if (X % 3 == 0) {
//                X /= 3;
//                calculation(X, tmp + 1);
//            }
//            if (X % 2 == 0){
//                X /= 2;
//                calculation(X, tmp + 1);
//            }
//            X--;
//            calculation(X, tmp + 1);
//        }
//    }
//}


// 정답코드
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1463_MakingOne {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(N));

    }

    static int recur(int N) {

        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }

}
