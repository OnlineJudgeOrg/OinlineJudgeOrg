package GraphTraversal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ24479_DFS1 {
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        visited = new boolean[N];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st2.nextToken());
            int tmp2 = Integer.parseInt(st2.nextToken());
            list[tmp1].add(tmp2);
            list[tmp2].add(tmp1);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list[i]);
            System.out.println(list[i]);
        }

        dfs(list, 1);




    }

    public static void dfs(ArrayList<Integer>[] list, int s) {



        for (int i = 0; i < list[s].size(); i++) {
            boolean tmp = visited[list[s].get(i)];
            if (!tmp) {
                System.out.println(list[s].get(i));
                tmp = true;
                dfs(list, list[s].get(i));
            }
        }
    }
}
