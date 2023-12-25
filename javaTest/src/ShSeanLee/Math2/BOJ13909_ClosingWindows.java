package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ13909_ClosingWindows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] window = new int[N + 1];
//        boolean[] window = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            window[i] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; i * j <= N; j++) {
                window[i * j] = closeOrOpen(window[i * j]);
            }
        }

        int sumArray = 0;
        for (int i = 0; i < N; i++) {
            if (window[i] == 1){
                sumArray++;
            }
        }
        System.out.println(sumArray);

    }

    public static int closeOrOpen(int status){
        if (status == 1){
            return 0;
        } else {
            return 1;
        }
    }

    // 순서대로 갈 것이 아니라, 해당 수가 각각 홀수번나오는지 짝수번 나오는지를 밝힌다.



}
