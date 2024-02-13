package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 풀이완료 (128ms)
// 탐색하는데 누적된 최솟값, 최댓값 등이 아니므로 일반적인 dfs로 풀이

public class BOJ2667_NumberingClusters {
    public static int[][] map;
    public static boolean[][] visited;
    public static int sizeOfMap;
    public static ArrayList<Integer> clusters = new ArrayList<>();;
    public static int cnt; // 클러스터 내, 집의 수를 카운팅하는 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfMap = Integer.parseInt(br.readLine());
        map = new int[sizeOfMap][sizeOfMap];
        visited = new boolean[sizeOfMap][sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++) {
            String isInHouse = br.readLine(); // "0110100"을 한글자씩 자르기 위함
            for (int j = 0; j < sizeOfMap; j++) {
                map[i][j] = isInHouse.charAt(j) - '0'; // char의 int 변환
            }
        }

        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                cnt = 0; //
                dfs(i, j);
//                System.out.println("-----------------");
                if (cnt != 0) {
                    clusters.add(cnt);
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(clusters); // 오름차순으로 정렬
        int numOfClusters = clusters.size();
        sb.append(numOfClusters).append("\n");

        for (int i = 0; i < numOfClusters; i++) {
            sb.append(clusters.get(i)).append("\n");
        }
        System.out.println(sb);



    }

    public static void dfs (int i, int j) {
        if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고(1), 방문하지 않은 것만 탐색
            cnt ++;
            visited[i][j] = true;
            if (j < sizeOfMap - 1 && (map[i][j + 1] == 1) && !visited[i][j + 1]) { // 오른쪽 끝에 있지 않고, 오른쪽 값이 1이고, 방문 안한 경우에만 
//                System.out.println(i + "," + j + "오");
                dfs (i, j + 1); // 오른쪽 + 1
            }
            if (i < sizeOfMap - 1 && (map[i + 1][j] == 1) && !visited[i + 1][j]) { // 아래쪽 끝에 있지 않고, 아래쪽 값이 1이고, 방문 안한 경우에만
//                System.out.println(i + "," + j + "아");
                dfs (i + 1, j); // 아래쪽 + 1
            }
            if (j != 0 && (map[i][j - 1] == 1) && !visited[i][j - 1]) { // 왼쪽 끝에 있지 않고, 왼쪽 값이 1이고, 방문 안한 경우에만
//                System.out.println(i + "," + j + "왼");
                dfs (i, j - 1); // 왼쪽 + 1
            }
            if (i != 0 && (map[i - 1][j] == 1) && !visited[i - 1][j]) { // 위쪽 끝에 있지 않고, 위쪽 값이 1이고, 방문 안한 경우에만
//                System.out.println(i + "," + j + "위");
                dfs (i - 1, j); // 위쪽 + 1
            }
            
        }
    }
}
