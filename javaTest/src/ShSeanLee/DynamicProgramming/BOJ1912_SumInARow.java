package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912_SumInARow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSum = 0;
        int tempSum = 0;
        boolean previousMinus = false;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp >= 0) {
                if (previousMinus) {
                    tempSum = 0;
                    previousMinus = false;
                }
                tempSum += tmp;
            } else {
                previousMinus = true;
                maxSum = Math.max(maxSum, tempSum);
                System.out.println(tempSum);
                // 0을 더하는 것과 같은 동작
            }
        }
        System.out.println(maxSum);


    }
}
