package Math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
M이상 N이하 소수 모두 출력하기 (248ms)
 */

public class BOJ1929_GetPrime { // 에라토스테네스의 체를 이용한 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[N+1];
        for (int i = 2; i < N + 1; i++) { // 0, 1은 모두 소수가 아니므로(나눠줄 값은 2부터)
            isPrime[i] = true;
        }

        makingPrimeArray(isPrime, N);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i < isPrime.length; i++) {
            if (isPrime[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);


    }

    public static void makingPrimeArray(boolean[] isPrime, int n){
        for (int i = 2; i < n; i++) {
            if(isPrime[i]){
                for (int j = 2; j * i <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}
