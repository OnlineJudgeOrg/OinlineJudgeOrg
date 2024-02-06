package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ1260_DFS_BFS {
    public static int numberOfNode; 
    public static int numberOfEdge;
    public static int vertex; // 시작 정점
    public static ArrayList<Integer>[] graphs;
    public static boolean[] visited; // dfs, bfs 공통 활용
    public static Deque<Integer> queue = new ArrayDeque<>(); // bfs를 위한 queue
    public static ArrayList<Integer> dfsResult = new ArrayList<>();
    public static ArrayList<Integer> bfsResult = new ArrayList<>();
    public static StringBuilder dfsOrder = new StringBuilder(); // 정답 출력용
    public static StringBuilder bfsOrder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        
        // 그래프 만들기
        graphs = new ArrayList[numberOfNode + 1];
        for (int i = 0; i < numberOfNode + 1; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st2.nextToken());
            int tmp2 = Integer.parseInt(st2.nextToken());
            graphs[tmp1].add(tmp2);
            graphs[tmp2].add(tmp1);
        }


        for (int i = 1; i < numberOfNode + 1; i++) {
            Collections.sort(graphs[i]);
        }

//        for (int i = 0; i < graphs.length; i++) {
//            System.out.println(graphs[i].toString());
//        }
        // DFS
        visited = new boolean[numberOfNode + 1];
        visited[vertex] = true;
        dfsResult.add(vertex);
        DFS(vertex, 1);
//        System.out.println(dfsOrder);
//        System.out.println(dfsResult.toString());
        for (int i = 0; i < dfsResult.size(); i++) {
            dfsOrder.append(dfsResult.get(i)).append(" "); // DFS 출력
        }
        System.out.println(dfsOrder);

        // BFS
        visited = new boolean[numberOfNode + 1];
        visited[vertex] = true;
        queue.addLast(vertex);
        BFS();
        for (int i = 0; i < bfsResult.size(); i++) {
            bfsOrder.append(bfsResult.get(i)).append(" ");
        }
        System.out.println(bfsOrder);

    }

    public static void DFS(int n, int depth) {
//        if (depth == numberOfNode) {
//            for (int i = 0; i < dfsResult.size(); i++) {
//                dfsOrder.append(dfsResult.get(i)).append(" ");
//            }
//        } else{
        for (int i = 0; i < graphs[n].size(); i++) {
            int tmp = graphs[n].get(i);
            if (!visited[tmp]) {
//                System.out.println(tmp);
                visited[tmp] = true;
                dfsResult.add(tmp);
                DFS(tmp, depth + 1); // 최초 방문 후 재방문 안하므로 false 없음
            }
        }
//        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
//            System.out.println(queue.toString());
            int removed = queue.removeFirst();
            bfsResult.add(removed);
            for (int i = 0; i < graphs[removed].size(); i++) {
                int tmp = graphs[removed].get(i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    queue.addLast(tmp);
                }
            }
        }
    }

}
