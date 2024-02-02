package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ9184_ExecuteFunction {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 & c == -1) {
                break;
            } else {
                result = function1(a, b, c);
            }

            String tmp = String.format("w(%d, %d, %d) = %d", a, b, c, result);
            System.out.println(tmp);
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);



    }

    public static int function1(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return function1(20, 20, 20);
        } else if (a < b && b < c) {
            return function1(a, b, c - 1) + function1(a, b - 1, c - 1) - function1(a, b - 1, c);
        } else {
            return function1(a - 1, b, c) + function1(a - 1, b - 1, c) + function1(a - 1, b , c - 1) - function1(a - 1, b - 1, c - 1);
        }
    }

}
