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
    public static StringBuilder sb = new StringBuilder();
    public static int[] result;
    public static int k = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1]; // 순서를 담을 배열

        for (int i = 0; i < N + 1; i++) {
            result[i] = 0;  // 0으로 채워둠
        }

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 그래프 만들기
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st2.nextToken());
            int tmp2 = Integer.parseInt(st2.nextToken());
            list[tmp1].add(tmp2);
            list[tmp2].add(tmp1);
        }
        // 정렳하기
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
            System.out.println(list[i]);
        }
        // 시작 노드는 true로 바꿔주고, 
        visited[s] = true;
//        System.out.println(s);
//        sb.append(s).append("\n");
        result[s] = k++; // 1부터 순서대로 넣는다.
        dfs(list, s);
//        for (int i = 1; i < visited.length; i++) {
//            if (!visited[i]){
////                System.out.println(0);
//                sb.append(0).append("\n");
//                break;
//            }
//        }
        for (int i = 1; i < N + 1; i++) {
//            System.out.println(result[i]);
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

//    public static void dfs(ArrayList<Integer>[] list, int s) { // 잘못된 함수 생성
//        for (int i = 0; i < list[s].size(); i++) {
//            if (!visited[list[s].get(i)]) {
////                System.out.println(list[s].get(i));
//                sb.append(list[s].get(i)).append("\n");
//                visited[list[s].get(i)] = true;
//                dfs(list, list[s].get(i));
//            }
//        }
//    }

    public static void dfs(ArrayList<Integer>[] list, int s) {
        for (int i = 0; i < list[s].size(); i++) {
            if (!visited[list[s].get(i)]) { // visited가 false인 것들만 돈다.
//                System.out.println(list[s].get(i));
                result[list[s].get(i)] = k++;
                visited[list[s].get(i)] = true;
                dfs(list, list[s].get(i));
            }
        }
    }

}
