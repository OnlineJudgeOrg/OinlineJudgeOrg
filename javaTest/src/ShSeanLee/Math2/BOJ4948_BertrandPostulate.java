package Math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
n초과 2n이하의 수에서 소수의 개수 구하기 (268ms)
 */
public class BOJ4948_BertrandPostulate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){ // 정지 조건
                break;
            } else {
                boolean[] isPrime = new boolean[2 * n + 1];
                for (int i = 2; i < 2 * n + 1; i++) { // 0, 1은 모두 소수가 아니므로(나눠줄 값은 2부터)
                    isPrime[i] = true;
                }

                makingPrimeArray(isPrime, 2 * n); // 2n을 하는 이유는 2n을 포함하든 안하든 어차피 2n자체는 소수가 아니므로 제외됨
                int cnt = 0;
                for (int i = n + 1; i < isPrime.length; i++) {
                    if (isPrime[i]){
                        cnt++;
//                        System.out.println(i);
//                        System.out.println("----");
                    }
                }
                sb.append(cnt).append("\n");
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
