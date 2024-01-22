package GraphTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ24444_BFS1 {
    public static int N;
    public static int M;
    public static int R;
    public static boolean[] visited;
    public static Deque<Integer> queue;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graphs = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graphs[i] = new ArrayList<Integer>();
        }

        // 그래프 만들기
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st2.nextToken());
            int tmp2 = Integer.parseInt(st2.nextToken());
            graphs[tmp1].add(tmp2);
            graphs[tmp2].add(tmp1);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graphs[i]);
        }

        visited = new boolean[N + 1];
        queue = new ArrayDeque<Integer>();

        int[] order = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            order[i] = 0;
        }

        // 시작 노드는 담아 둔다.
        visited[R] = true;
        queue.addLast(R);
//        System.out.println(queue);
        int idx = 1;
        order[R] = idx;
        idx++;
        while (!queue.isEmpty()) {
            // 큐에 있는 맨 앞 수 pop
            Integer n0 = queue.removeFirst();
//            System.out.print(n0);
//            System.out.println(graphs[n0]);

            // 인접한 노드를 큐에 담기
            for (int i = 0; i < graphs[n0].size(); i++) {
                int n = graphs[n0].get(i);
                if (!visited[n]) {
                    visited[n] = true;
                    order[n] = idx;
//                    System.out.println(n);
                    queue.addLast(n);
                    idx++;
                }
            }


        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }




}
