package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGBStreet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfHouses = Integer.parseInt(br.readLine());
        int[][] costs = new int[numberOfHouses][3];

        for (int i = 0; i < numberOfHouses; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < numberOfHouses; i++) { // 행
            for (int j = 0; j < 3; j++) { // 열
//                int tmp = 1000;
                /*반례
                3
                999 1000 1000
                1000 999 1000
                1000 1000 999
                 */
                int tmp = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        tmp = Math.min(tmp, costs[i - 1][k]);
                    }
                }
                costs[i][j] += tmp;
            }
        }

//        System.out.println(costs[1][0]);
//        System.out.println(costs[1][1]);
//        System.out.println(costs[1][2]);
        int result = costs[numberOfHouses - 1][0];
        for (int i = 1; i < 3; i++) {
            result = Math.min(costs[numberOfHouses - 1][i], result);
        }
        System.out.println(result);


    }
}
