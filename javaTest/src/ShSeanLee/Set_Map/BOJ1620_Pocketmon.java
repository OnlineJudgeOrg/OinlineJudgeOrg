package Set_Map;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class BOJ1620_Pocketmon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dict = new String[N+1]; // 1번부터 도감이 시작하므로
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map.put(tmp, i+1); // "Bulbasaur" : 0 - 해시맵을 만든다 (문자 들어왔을때 숫자 출력용)
            dict[i+1] = tmp; // 숫자 들어왔을 때 문자 출력용 배열을 만든다.(숫자 들어왔을 때 문자 출력용)
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            String tmp2 = br.readLine();
            if(map.get(tmp2) == null){ // 숫자라면(숫자는 해시맵에서 key로 정의하지 않음)
                sb.append(dict[Integer.parseInt(tmp2)]).append("\n");
            } else { // 문자라면,
                sb.append(map.get(tmp2)).append("\n");
            }

        }
        System.out.println(sb);



    }


}
