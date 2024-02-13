package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 272ms
// 연속된 합을 dp로 풀어내기
public class BOJ1912_SumInARow_v3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        sequence[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sequence[i] = Math.max(sequence[i - 1] + tmp, tmp); // max (이전까지 + 현재, 현재) -> 마이너스 인 경우 현재가 더 크고, 새롭게 연속합이 시작됨
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(sequence[i], maxi); // 배열에서 최댓값을 구함
        }

        System.out.println(maxi);

    }
}
