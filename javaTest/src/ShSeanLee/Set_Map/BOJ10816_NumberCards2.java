package Set_Map;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class BOJ10816_NumberCards2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (map.get(tmp) == null){ // 처음 나오는 값이면 1을 value에 넣음
                map.put(tmp, 1);
            } else{ // 정의된 거면, 원래 값에 1을 넣어서 변경
                map.put(tmp, map.get(tmp) + 1);
            }

        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int tmp2 = Integer.parseInt(st2.nextToken());
            if(map.get(tmp2) == null){ // null이면 0으로 바꿈
                sb.append(0).append(" ");
            }else{
                sb.append(map.get(tmp2)).append(" "); // 그 갯수만큼 출력
            }
        }
        System.out.println(sb);


    }
}
