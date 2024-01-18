package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 1~N 범위에서 중복없이 M개를 고르는 것. 단, 뒤에 나온수는 앞에 나온수보다 커야 함 

public class BOJ15650_NAndM2 {
//    public static boolean[] visited;
    public static int[] numbers;

    public static int N;
    public static int M;
    public static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        sb = new StringBuilder();
        DFS(1, 0);
        System.out.println(sb);
    }


    public static void DFS(int n, int depth) { // n은 시작 숫자

        if (depth == M) {
            for (int v : numbers) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = n; i <= N; i++) {
            numbers[depth] = i;
            DFS(i + 1, depth + 1);
        }
    }
}
