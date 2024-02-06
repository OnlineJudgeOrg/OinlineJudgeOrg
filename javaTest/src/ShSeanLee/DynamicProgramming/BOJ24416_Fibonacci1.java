package DynamicProgramming;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BOJ24416_Fibonacci1 {
    public static ArrayList<Integer> fibonacciArray = new ArrayList<>();
    public static int case1rept = 0; // 코드1 실행횟수 카운팅
    public static int case2rept = 0; // 코드2 실행횟수 카운팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);
        System.out.println(case1rept);
        System.out.println(case2rept);

    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            ++case1rept;
            return 1;
        } else {
//            ++case1rept;
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {

        fibonacciArray.add(0, 0);
        fibonacciArray.add(1, 1);
        fibonacciArray.add(2, 1);
        for (int i = 3; i < n + 1; i++) {
            ++case2rept;
            fibonacciArray.add(i, fibonacciArray.get(i - 1) + fibonacciArray.get(i - 2)); // memorization을 활용하지 않는 풀이(반복 연산아니고 한번만 연산)
        }
        return fibonacciArray.get(n);
    }
}
