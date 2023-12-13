package Math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ4134_NextPrime {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCases; i++) {
//            int n = Integer.parseInt(br.readLine());
            long n = Long.parseLong(br.readLine());
            if (n == 0L || n == 1L){ // 0과 1일때 모두 2가 나와야함(0, 1은 소수가 아님)
//                System.out.println(2);
                sb.append(2).append("\n");
            } else {
                while(true){
                    if(isPrime(n)){
//                        System.out.println(n);
                        sb.append(n).append("\n");
                        break;
                    }
                    n++; // 문제를 잘 읽어야 함.. n보다 크거나 "같은" 소수
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrime(long n){
        boolean result = true;
        for (long i = 2L; i * i <= n; i++) { // i * i <= n <동치> i <= Math.sqrt(n)
            if(n % i == 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
