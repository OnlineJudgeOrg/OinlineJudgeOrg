package Backtracking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 1~N 범위에서 중복없이 M개를 고르는 것

public class BOJ15649_NAndM {
    public static int[] numbers;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        numbers = new int[M];

        DFS(N, M, 0);
        System.out.println(sb);





    }
    public static void DFS(int N, int M, int depth){
//        StringBuilder sb = new StringBuilder();
        // 조건을 먼저 검사하는 이유는, depth + 1을 파라미터로 넘겨받기 때문임.
        if (depth == M) { // 단, 끝까지 돈 것들만
            for (int n : numbers){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true; // 중복 된 두 값을 선택하지 않기 위한 장치
                numbers[depth] = i + 1;
                DFS(N, M, depth + 1);
                visited[i] = false; // 임시로 true했던 애들 다시 false로 바꾸기
            }
        }

        // 재귀적으로 depth가 M이 되면 종료
        // 그게 아니면 계속해서 파고들기
        // 이미 일차원배열에 존재하는 숫자는 제외(한정조건)

    }
}
