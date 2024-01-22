package Backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889_StartAndLink {
    public static int N;
    public static int[][] stats;
    public static boolean[] visited;
//    public static int[] team1;
//    public static int[] team2;
//    public static int[][] teams;

    public static int m = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 그래프 만들 때부터, (i, j), (j, i) 값을 합한 것을 넣어버리기.
        stats = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 3 3 으로 나누기 - by dfs
        visited = new boolean[N];
//        team1 = new int[N / 2];
//        team2 = new int[N / 2];

        dfs(0, 0);

        // 두개의 셋에서 둘씩 뽑아서 순서쌍 만들기



        // abs(sum(set1) - sum(set2))
        System.out.println(m);


    }

    public static void dfs(int idx, int depth) { // 0 ~ N을 true, false 두 집단으로 나누기
        if (depth == N/2) {
//            int memberNumber = 0;
//            for (int i = 0; i < visited.length; i++) {
//                if (!visited[i]) {
////                    System.out.println(memberNumber);
//                    team2[memberNumber] = i;
//                    memberNumber++;
//                }
//            }

            //
            int team1Score = 0;
            int team2Score = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) { //  팀 구별의 아이디어
                        team1Score += stats[i][j];
                        team1Score += stats[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        team2Score += stats[i][j];
                        team2Score += stats[j][i];
                    }
                }
            }

            // 순서쌍에 해당하는 숫자 합해서 sum(set1) - sum(set2) 만들기
            m = Math.min(m, Math.abs(team1Score - team2Score));
            return;
        }

        for (int i = idx; i < N; i++) { // 재귀로 들어가서, 처음부터 도는 것이 아니라, 지금까지 안나온 애들(조합으로 가야함)
            if (!visited[i]) {
                visited[i] = true;
//                team1[depth] = i;
//                System.out.println(depth);
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

//    // team 배열에서 2개씩 뽑아서 누적 합 구하기
//    public static int getSum (int[] team) {
//        int sumOfStats = 0;
//        for (int i = 0; i < team.length - 1; i++) {
//            for (int j = i + 1; j < team.length; j++) {
//                sumOfStats += stats[team[i]][team[j]] + stats[team[j]][team[i]];
//            }
//        }
//        return sumOfStats;
//    }


}
