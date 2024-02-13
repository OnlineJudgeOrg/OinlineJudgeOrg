package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 풀이완료(140ms)
// 윗줄 아랫줄 같은 열에 있으면 안되는 것이 유일한 조건
// 비용의 최솟값을 구하는 것이므로 dp
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
                for (int k = 0; k < 3; k++) { // 
                    if (k != j) {
                        tmp = Math.min(tmp, costs[i - 1][k]); // ex: 0번째(k) 열이 아닌 이전 행의 1, 2번째 열의 최솟값
                    }
                }
                costs[i][j] += tmp; // 최솟값을 누적해서 더한다.
            }
        }

//        System.out.println(costs[1][0]);
//        System.out.println(costs[1][1]);
//        System.out.println(costs[1][2]);
        // costs[1][0], costs[1][1], costs[1][2]의 최솟값 구하기
        int result = costs[numberOfHouses - 1][0];
        for (int i = 1; i < 3; i++) {
            result = Math.min(costs[numberOfHouses - 1][i], result);
        }
        System.out.println(result);


    }
}
