package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.HashSet;

/*
long을 쓰는것, HashSet이나 배열을 쓰면 시간초과와 메모리초과가 발생. 홀수개 짝수개까지는 파악했으나 어떤 상황에서 발생하는지 파악 실패
 */

public class BOJ13909_ClosingWindows {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] window = new int[N + 1];
////        boolean[] window = new boolean[N + 1];
//        for (int i = 0; i < N; i++) {
//            window[i] = 0;
//        }
//
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; i * j <= N; j++) {
//                window[i * j] = closeOrOpen(window[i * j]);
//            }
//        }
//
//        int sumArray = 0;
//        for (int i = 0; i < N; i++) {
//            if (window[i] == 1){
//                sumArray++;
//            }
//        }
//        System.out.println(sumArray);
//
//    }
//
//    public static int closeOrOpen(int status){
//        if (status == 1){
//            return 0;
//        } else {
//            return 1;
//        }
//    }

    // 순서대로 갈 것이 아니라, 해당 수가 각각 홀수번나오는지 짝수번 나오는지를 밝힌다. - 여기까지는 했는데 홀수번의 특징 파악을 제대로 못해서 실패.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int windowOpened = 0;
//        for (long i = 1L; i < N + 1; i++) {
////            System.out.print(i);
////            System.out.println(getDivisor(i));
////            if (getDivisor(i) % 2 == 1){
////                windowOpened ++;
////            }
//            if (getDivisor(i) == 1){
//                windowOpened ++;
//            }
//
//        }
        for (long i = 1; i * i <= N; i++) {
            windowOpened ++;
        }
//        System.out.println();
        System.out.println(windowOpened);

    }

//    public static long getDivisor(long N){ // hashset을 이용한 풀이
//        // 약수의 개수를 구하는 코드
//        if (N == 1){
//            return 1;
//        } else {
//            HashSet<Long> set = new HashSet<>();
////            int numOfDivisor = 2;
////            int tmp = 0;
//            for (long i = 2; i * i <= N; i++) { // 약수를 구하는 과정 -> 쌍으로 집어넣기 (루트 값은 중복되므로 set으로)
//                if(N % i == 0){
//                    set.add(i);
//                    set.add(N/i);
////                    tmp ++;
//                }
//            }
//            int numOfDivisor = set.size();
//
////            if (N / Math.sqrt(N) == Math.sqrt(N)){
////                numOfDivisor += (tmp-1) * 2 + 1;
////            } else {
////                numOfDivisor += tmp * 2;
////            }
//            return numOfDivisor;
//        }
//    }

//    public static long getDivisor(long N){ // 배열 및 set을 이용하지 않는 풀이
//        // 약수의 개수를 구하는 코드
//        if (N == 1){
//            return 1;
//        } else {
////            HashSet<Long> set = new HashSet<>();
////            int numOfDivisor = 2;
//            int numOfDivisor = 0;
//            int tmp = 0;
//            for (long i = 2; i * i <= N; i++) {
//                if(N % i == 0){
////                    set.add(i);
////                    set.add(N/i);
//                    if (i * i == N){
////                        tmp ++;
//                        numOfDivisor ++;
//                    }
////                    else {
////                        tmp += 2;
////                    }
//                }
//            }
////            numOfDivisor += tmp;
////            int numOfDivisor = set.size();
//
////            if (N / Math.sqrt(N) == Math.sqrt(N)){
////                numOfDivisor += (tmp-1) * 2 + 1;
////            } else {
////                numOfDivisor += tmp * 2;
////            }
//            return numOfDivisor;
//        }
//    }



}
