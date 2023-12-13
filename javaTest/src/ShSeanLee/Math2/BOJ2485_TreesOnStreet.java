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

        int[] distance = new int[N-1]; // N-1 길이의 두 가로수 사이의 거리를 담는 배열
        int gcd = 0;
        for (int i = 0; i < N-1; i++) {
            // 배열 돌면서 인접한 수 사이의 거리를 담음
            int d = arr[i+1] - arr[i];
            distance[i] = d;
            // 여러 수의 최대공약수를 구함 - 이부분이 관건 (유클리드 호제법에 대한 이해)
            gcd = getGCD(d, gcd); // distance에 담으면서, 그 거리를 현재의 최대공약수와 계속 비교하면서 담기

        }

        int result = 0;

        for (int i = 0; i < N - 1; i++) {
            int quotient = distance[i]/gcd;
            result += quotient-1; // GCD로 나눈 값 에서 -1을 한 값의 총합 ex: 1 3 7 13
            //                                                            2 4 6  -> 1-1, 2-1, 3-1
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
