package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2667_NumberingClusters {
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfMap = Integer.parseInt(br.readLine());
        int[][] map = new int[sizeOfMap][sizeOfMap];
        visited = new boolean[sizeOfMap][sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++) {
            String isInHouse = br.readLine();
            for (int j = 0; j < sizeOfMap; j++) {
                map[i][j] = isInHouse.charAt(j) - '0';
            }
        }


    }

    public static void dfs (int[][] map, int sizeOfMap) {
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                if (map[i][j] == 1) {
                    if (!visited[i][j] && i >= 1 && j >= 1) {
                        visited[i][j] = true;

                    }
                }
            }
        }
    }
}
