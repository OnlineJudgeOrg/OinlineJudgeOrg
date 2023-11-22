package ShSeanLee;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ11651_SortingCoordinates2 {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                if (o1[1].equals(o2[1])){ // y좌표가 같다면,
                    return o1[0] - o2[0]; // x좌표가 증가하는 순으로(오름차순)
                } else {
                    return o1[1] - o2[1]; // y좌표가 증가하는 순으로(오름차순)
                }
            }

        });

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);


    }
}
