package GraphTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2606_Virus {

    public static int numOfComputer;
    public static int numOfConnected;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graphs;
    public static HashSet<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numOfComputer = Integer.parseInt(br.readLine());
        numOfConnected = Integer.parseInt(br.readLine());

        visited = new boolean[numOfComputer + 1];
        graphs = new ArrayList[numOfComputer + 1];

        for (int i = 0; i < numOfComputer + 1; i++) {
            graphs[i] = new ArrayList<>();
        }
        result = new HashSet<>();


        for (int i = 0; i < numOfConnected; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
//            System.out.println(tmp1);
//            System.out.println(tmp2);
            graphs[tmp1].add(tmp2);
            graphs[tmp2].add(tmp1);
        }

        for (int i = 0; i < graphs.length; i++) {
            Collections.sort(graphs[i]);
        }

        visited[1] = true;

        dfs(1);
        System.out.println(result.size());




    }

    public static void dfs(int s) {
        for (int i = 0; i < graphs[s].size(); i++) {
            if (!visited[graphs[s].get(i)]){
//                System.out.println(graphs[s].get(i));
                visited[graphs[s].get(i)] = true;
                result.add(graphs[s].get(i));
                dfs(graphs[s].get(i));
            }
        }

    }
}
