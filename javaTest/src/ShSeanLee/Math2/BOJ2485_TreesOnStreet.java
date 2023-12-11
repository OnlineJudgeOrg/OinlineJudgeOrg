package Math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class BOJ2485_TreesOnStreet { // 252ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] distance = new int[N-1];
        int gcd = 0;
        for (int i = 0; i < N-1; i++) {
            // 배열 돌면서 인접한 수 사이의 거리를 담음
            int d = arr[i+1] - arr[i];
            distance[i] = d;
            // 여러 수의 최대공약수를 구함 - 이부분이 관건 (유클리드 호제법에 대한 이해)
            gcd = getGCD(d, gcd);

            // GCD로 나눈 값 에서 -1을 한 값의 총합
        }

        int result = 0;

        for (int i = 0; i < N - 1; i++) {
            int quotient = distance[i]/gcd;
            result += quotient-1;
        }
        System.out.println(result);
    }

    public static int getGCD(int a, int b){ 
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
