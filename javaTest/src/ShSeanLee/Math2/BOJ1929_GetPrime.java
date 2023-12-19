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
        boolean[] isPrime = new boolean[N+1]; // 최초 생성시에는 false로 되어있음
        for (int i = 2; i < N + 1; i++) { // 0, 1은 모두 소수가 아니므로(나눠줄 값은 2부터)
            isPrime[i] = true;
        }

        makingPrimeArray(isPrime, N); // 마지막 값인 N까지 만듦
        StringBuilder sb = new StringBuilder();
        for (int i = M; i < isPrime.length; i++) { // M부터
            if (isPrime[i]){ // true 되어있는 것들만
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);


    }

    public static void makingPrimeArray(boolean[] isPrime, int n){
        for (int i = 2; i < n; i++) {
            if(isPrime[i]){ // 모든 값을 true로 바꾼 array로 출발
                for (int j = 2; j * i <= n; j++) { // 에라토스테네스의 체에 따라서, i의 배수를 fals로 만드는 방식
                    isPrime[i * j] = false;
                }
            }
        }
    }
}
