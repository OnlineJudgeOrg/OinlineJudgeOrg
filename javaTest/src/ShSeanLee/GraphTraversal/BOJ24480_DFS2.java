package GraphTraversal;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24480_DFS2 {
    public static int N, M, R;
    public static ArrayList<Integer>[] lists;
    public static boolean[] visited;
    public static int[] result;
    public static int k = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];



        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N + 1; i++) {
            result[i] = 0;  // 0으로 채워둠
        }


        for (int i = 0; i < M; i++) { // 그래프 만들기
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st1.nextToken());
            int tmp2 = Integer.parseInt(st1.nextToken());
            lists[tmp1].add(tmp2);
            lists[tmp2].add(tmp1);
        }

        // 정렬하기
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(lists[i], Collections.reverseOrder());
        }

        visited[R] = true;
        result[R] = k++;

        dfs(lists, R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append("\n"); // 순서대로 뽑는다.
        }
        System.out.println(sb);


    }

    public static void dfs (ArrayList<Integer>[] lists, int s) {
        for (int i = 0; i < lists[s].size(); i++) {
            if (!visited[lists[s].get(i)]) {
                result[lists[s].get(i)] = k++;
                visited[lists[s].get(i)] = true;
                dfs(lists, lists[s].get(i));


            }
        }
    }










}
