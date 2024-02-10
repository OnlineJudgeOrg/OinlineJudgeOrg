package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1912_SumInARow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSum = 0;
        int tempSum = 0;
        ArrayList<Integer> manipulatedArray = new ArrayList<>();
//        boolean previousMinus = false; // 직전이 마이너스냐에 따라서 새로 수열을 자르려고 한 풀이(잘못됨)
        // 핵심 아이디어 -> 양수는 앞뒤 인접한 애들을 끌어들이는게 무조건 이득이므로 합쳐버린다. -> 2% 시간초과
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
//        System.out.println(manipulatedArray.toString());
        System.out.println(dp(manipulatedArray, manipulatedArray.size()));

    }

    public static int dp(ArrayList<Integer> manipulatedArray, int n) {
        int result = -1000;
        int SumInARow = 0;
        for (int i = 1; i < n + 1; i++) { // i개의 연속된 숫자의 합
            for (int j = 0; j < n - i + 1; j++) { // i개 연속 숫자의 합의 첫번째 값
                for (int k = j; k < j + i; k++) {
//                    System.out.println(k);
                    SumInARow += manipulatedArray.get(k);
                }
                result = Math.max(result, SumInARow);
                SumInARow = 0;
            }
        }
        return result;
    }

}
