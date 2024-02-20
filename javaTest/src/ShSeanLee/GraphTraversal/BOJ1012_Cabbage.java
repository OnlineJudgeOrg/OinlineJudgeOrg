package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_Cabbage {
    public static int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래쪽, 왼쪽, 위쪽
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // dx dy를 활용한 풀이
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            int numberOfColums = Integer.parseInt(st.nextToken());
            int numberOfRows = Integer.parseInt(st.nextToken());
            int numberOfCabbages =  Integer.parseInt(st.nextToken());

            int[][] isThereCabbage = new int[numberOfColums][numberOfRows];
            boolean[][] visited = new boolean[numberOfColums][numberOfRows];



            for (int i = 0; i < numberOfCabbages; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                isThereCabbage[x][y] = 1;
            }

            int numberOfWorms = 0;

            for (int i = 0; i < numberOfColums; i++) {
                for (int j = 0; j < numberOfRows; j++) {
                    if(isThereCabbage[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        numberOfWorms++;
                        dfs(i, j, numberOfColums, numberOfRows, isThereCabbage, visited);
                    }
                }
            }

            sb.append(numberOfWorms).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int x, int y, int numberOfColums, int numberOfRows, int[][] isThereCabbage, boolean[][] visited){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((nx >= 0) && (ny >= 0) && (nx < numberOfColums) && (ny < numberOfRows)){
                if (isThereCabbage[nx][ny] == 1 & !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx, ny, numberOfColums, numberOfRows, isThereCabbage, visited);
                }
            }

        }


    }

}
