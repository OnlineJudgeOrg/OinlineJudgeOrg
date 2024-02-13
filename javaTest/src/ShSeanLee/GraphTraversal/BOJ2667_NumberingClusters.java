package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667_NumberingClusters {
    public static int[][] map;
    public static boolean[][] visited;
    public static int sizeOfMap;
    public static ArrayList<Integer> clusters = new ArrayList<>();;
    public static int tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfMap = Integer.parseInt(br.readLine());
        map = new int[sizeOfMap][sizeOfMap];
        visited = new boolean[sizeOfMap][sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++) {
            String isInHouse = br.readLine();
            for (int j = 0; j < sizeOfMap; j++) {
                map[i][j] = isInHouse.charAt(j) - '0';
            }
        }

        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                tmp = 0;
                dfs(i, j);
//                System.out.println("-----------------");
                if (tmp != 0) {
                    clusters.add(tmp);
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(clusters);
        int numOfClusters = clusters.size();
        sb.append(numOfClusters).append("\n");
        for (int i = 0; i < numOfClusters; i++) {
            sb.append(clusters.get(i)).append("\n");
        }
        System.out.println(sb);



    }

    public static void dfs (int i, int j) {
        if (map[i][j] == 1 && !visited[i][j]) {
            tmp ++;
            visited[i][j] = true;
            if (j < sizeOfMap - 1 && (map[i][j + 1] == 1) && !visited[i][j + 1]) { // 오른쪽 + 1
//                System.out.println(i + "," + j + "오");
                dfs (i, j + 1);
            }
            if (i < sizeOfMap - 1 && (map[i + 1][j] == 1) && !visited[i + 1][j]) { // 아래쪽 + 1
//                System.out.println(i + "," + j + "아");
                dfs (i + 1, j);
            }
            if (j != 0 && (map[i][j - 1] == 1) && !visited[i][j - 1]) { // 왼쪽 + 1
//                System.out.println(i + "," + j + "왼");
                dfs (i, j - 1);
            }
            if (i != 0 && (map[i - 1][j] == 1) && !visited[i - 1][j]) { // 위쪽 + 1
//                System.out.println(i + "," + j + "위");
                dfs (i - 1, j);
            }
            
        }
    }
}
