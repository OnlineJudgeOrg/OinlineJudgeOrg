package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class BOJ15651_NAndM3 {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];

        DFS(0);
        System.out.println(sb);


    }

    public static void DFS(int depth) {

        if(depth == M){
            for (int v : numbers) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[depth] = i + 1;
            DFS(depth + 1);
        }
    }

}
