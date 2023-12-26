package Math2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/*
에라스토테네스의 체를 활용하기 (612ms, 480ms - i * i <= N 까지만 탐색시에
 */

public class BOJ17103_GoldBachPartition {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(getPrime(N)).append("\n");
        }

        System.out.println(sb);


    }

    public static int getPrime(int N){
//        int[] primes = new int[N];
        boolean[] isPrime = new boolean[N+1];
//        ArrayList<Integer> primes = new ArrayList<>();
        int cnt = 0;
        for (int i = 2; i < N+1; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]){
                for (int j = 2; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
//        for (int i = 0; i < isPrime.length; i++) {
//            System.out.println(isPrime[i]);
//        }
        for (int i = 0; i < (N / 2) + 1; i++) { // 절반까지만 돈다. (짝으로 나오니까)
//            if (isPrime[i] == true){
//                primes.add(i);
//            }
            if (isPrime[i]){ // i가 소수일때,
                if (isPrime[N - i] == true){ // N - i도 소수이면, 골드바흐 파티션임
//                    System.out.println(i);
                    cnt++;
                }
            }

        }



//        System.out.println(primes);
        return cnt;
    }
}
