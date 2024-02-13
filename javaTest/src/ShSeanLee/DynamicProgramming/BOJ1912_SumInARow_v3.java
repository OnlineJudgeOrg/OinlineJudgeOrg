package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 272ms
public class BOJ1912_SumInARow_v3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        sequence[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sequence[i] = Math.max(sequence[i - 1] + tmp, tmp);
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(sequence[i], maxi);
        }

        System.out.println(maxi);

    }
}
