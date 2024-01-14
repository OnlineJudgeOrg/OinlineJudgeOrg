package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 한정조건을 위한 visited를 활용한다.
public class BOJ14888_ArithmeticOperator {
    public static int N;
    public static int[] numOfOperator; // +, -, x, ÷
    public static int[] result;
    public static boolean[] visited; // 각 인덱스의 연산자가 나왔는지, 예제3) {+, +, -, x, ÷}가 나왔는지
    public static int[] numbers;
    public static int maximum = -1000000000;
    public static int minimum = 1000000000;
    public static int n = 0;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        numOfOperator= new int[N - 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
//            System.out.print(i);
            int tmp = Integer.parseInt(st2.nextToken());
            for (int j = 0; j < tmp; j++) {
//                System.out.print(" ");
//                System.out.println(j);
                numOfOperator[n] = i; // 0, 0, 1, 2, 3
//                System.out.println(n);
                n++;
            }
        }
//        for(int v : numOfOperator) {
//            System.out.print(v);
//        }
//        System.out.println();
        // 중복이 제거 하지 않은 상태로 구해도 답은 구해질듯
        visited = new boolean[N - 1];
        result = new int[N - 1];

        dfs(0);
        System.out.println(maximum);
        System.out.println(minimum);





    }

    public static void dfs(int depth) {
        int sumOfResult = numbers[0];
        if (depth == N - 1) {
//            for (int vv: result) {
//                System.out.println(vv);
//            }
            for (int i = 0; i < N - 1; i++) {
                sumOfResult = arithemticOperator(sumOfResult, numbers[i + 1], result[i]);
            }
//            System.out.println(sumOfResult);
//            System.out.println();
            maximum = Math.max(maximum, sumOfResult);
            minimum = Math.min(minimum, sumOfResult);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numOfOperator[i];
                dfs(depth + 1);
                visited[i] = false;
                while (i + 1 < visited.length && numOfOperator[i] == numOfOperator[i + 1]) {
                    i++; // 중복된 연산자 건너뛰기
                }
            }
        }
    }

    public static int arithemticOperator(int num1, int num2, int aOperator) {
        int result = 0;
        switch (aOperator) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result =  num1 - num2;
                break;
            case 2:
                result =  num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
        }
        return result;
    }

}
