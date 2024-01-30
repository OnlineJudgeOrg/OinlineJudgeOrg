package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24445_BFS2 {
    public static int N;
    public static int M;
    public static int R;

    public static ArrayList<Integer>[] graphs;
    public static Deque<Integer> queue;
    public static boolean[] visited;
    public static int[] result;
    public static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st1.nextToken());
            int tmp2 = Integer.parseInt(st1.nextToken());
            graphs[tmp1].add(tmp2);
            graphs[tmp2].add(tmp1);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graphs[i], Collections.reverseOrder());
        }


        visited = new boolean[N + 1];
        queue = new ArrayDeque<Integer>();
        result = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            result[i] = 0;
        }

        queue.addLast(R);
        visited[R] = true;
        idx = 1;
        result[R] = idx;

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int tmp = queue.removeFirst();
            for (int i = 0; i < graphs[tmp].size(); i++) {
                int n = graphs[tmp].get(i);
                if(!visited[n]){
                    idx++;
                    visited[n] = true;
                    result[n] = idx;
                    queue.addLast(n);
                }
            }


        }
    }
}
