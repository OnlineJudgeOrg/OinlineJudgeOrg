package Math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.TreeSet;

// 1934 최소공배수: 성공(552ms) + TreeSet 풀이(424ms)
public class BOJ1934_LeastCommonMultiple {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 갯수
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < T; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int number1 = Integer.parseInt(st.nextToken());
//            int number2 = Integer.parseInt(st.nextToken());
//            int GreatestDivisor = getGCDivisor(number1, number2); // 두 숫자의 최대 공약수를 구함
//            int restNumber1 = number1/GreatestDivisor; // 원래수에서 최대 공약수를 나눈 첫번째 수
//            int restNumber2 = number2/GreatestDivisor; // 원래수에서 최대 공약수를 나눈 두번째 수
//
//            sb.append(GreatestDivisor * restNumber1 * restNumber2).append("\n"); // 두 수와 최대공약수를 곱함
//        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            int GreatestDivisor = getGCDivisor2(number1, number2); // 두 숫자의 최대 공약수를 구함
            int restNumber1 = number1/GreatestDivisor; // 원래수에서 최대 공약수를 나눈 첫번째 수
            int restNumber2 = number2/GreatestDivisor; // 원래수에서 최대 공약수를 나눈 두번째 수

            sb.append(GreatestDivisor * restNumber1 * restNumber2).append("\n"); // 두 수와 최대공약수를 곱함
        }

        System.out.println(sb);

    }
    // 최대공약수를 출력하는 메서드
    public static int getGCDivisor(int number1, int number2){ 
        HashSet<Integer> Divisor1 = getDivisor(number1);
        HashSet<Integer> Divisor2 = getDivisor(number2);
        Divisor1.retainAll(Divisor2); // 공약수를 구함
        return getMax(Divisor1); // TreeSet으로 하고 제일 마지막 값을 출력하는 방법도 있음
    }

    // 약수 전체 집합을 출력하는 메서드
    public static HashSet<Integer> getDivisor(int number){
        HashSet<Integer> set = new HashSet<>();
        if (number == 1){ // 1일 때는 약수의 집합은 {1}
            set.add(1);
        } else {
            for (int i = 1; i < number / 2 + 1; i++) { // 절반만 돌고, 약수일때는 원래수에서 그 약수를 나누면 대응되는 값이 나옴
                if (number % i == 0) { // 나누어 떨어질 때(= 약수일 때)
                    set.add(i);
                    set.add(number / i); // 대응되는 약수
                }
            }
        }
        return set;
    }

    // 최대공약수를 출력하는 메서드 - 배열에서 최대 값을 출력하는 메서드
    public static int getMax(HashSet<Integer> set){
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr); // Set을 arr로 바꿈
        int max = 1;
        for (int i = 0; i < set.size(); i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    // TreeSet
    public static int getGCDivisor2(int number1, int number2){
        TreeSet<Integer> Divisor1 = getDivisor2(number1);
        TreeSet<Integer> Divisor2 = getDivisor2(number2);
        Divisor1.retainAll(Divisor2); // 공약수를 구함
        return getMax2(Divisor1); // TreeSet으로 하고 제일 마지막 값을 출력하는 방법도 있음
    }

    // 약수 전체 집합을 출력하는 메서드 - TreeSet
    public static TreeSet<Integer> getDivisor2(int number){
        TreeSet<Integer> set = new TreeSet<>();
        if (number == 1){ // 1일 때는 약수의 집합은 {1}
            set.add(1);
        } else {
            for (int i = 1; i < number / 2 + 1; i++) { // 절반만 돌고, 약수일때는 원래수에서 그 약수를 나누면 대응되는 값이 나옴
                if (number % i == 0) { // 나누어 떨어질 때(= 약수일 때)
                    set.add(i);
                    set.add(number / i); // 대응되는 약수
                }
            }
        }
        return set;
    }

    // 배열에서 최대 값을 출력하는 메서드 - TreeSet
    public static int getMax2(TreeSet<Integer> set){
        return set.last();
    }


}
