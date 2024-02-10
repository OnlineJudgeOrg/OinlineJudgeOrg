package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1912_SumInARow_v2 { // 메모리초과
    public static ArrayList<Integer>[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSum = 0;
        int tempSum = 0;
        ArrayList<Integer> manipulatedArray = new ArrayList<>();



        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp >= 0) {
                tempSum += tmp;
            } else { // 마이너스 일때,
                if (tempSum != 0) { // 이전까지 합한 연속합이 존재하면,
                    manipulatedArray.add(tempSum);
                    tempSum = 0;
                }
                manipulatedArray.add(tmp);

            }
        }
        if (tempSum != 0) { // 마지막 값이 +인 경우의 수
            manipulatedArray.add(tempSum);
        }

        // 1 ~ n개로 이루어진 부분 수열을 담는 객체 배열
        int newSize = manipulatedArray.size();
        dp = new ArrayList[newSize + 1];
        for (int i = 0; i < newSize + 1; i++) {
            dp[i] = new ArrayList<>();
        }


        int result = dpSearch(manipulatedArray, newSize);
//        for (int i = 1; i < newSize + 1; i++) {
//            System.out.println(dp[i].toString());
//        }
        System.out.println(result);



    }

    public static int dpSearch(ArrayList<Integer> manipulatedArray, int n) {
        int SumInARow = 0;
        int result = -1000;
        for (int i = 1; i < n + 1; i++) { // i개의 연속된 숫자의 합
            if (dp[i - 1].isEmpty()) {
//                System.out.println("yes");
                for (int j = 0; j < n - i + 1; j++) { // i개 연속 숫자의 합의 첫번째 인덱스
                    for (int k = j; k < j + i; k++) {
                        SumInARow += manipulatedArray.get(k);
                    }
                    result = Math.max(result, SumInARow);
                    dp[i].add(SumInARow);
                    SumInARow = 0;
                }
                System.out.println(dp[i].toString());
            } else {
//                System.out.println("no");
                for (int j = 0; j < dp[i - 1].size() - 1; j++) {
                    int tmp = dp[i - 1].get(j) + manipulatedArray.get(i + j - 1);
                    result = Math.max(result, tmp);
                    dp[i].add(tmp);
                }
            }
        }
        return result;
    }

}
