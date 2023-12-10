package Set_Map;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BOJ14425_StringSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> sets = new HashMap<>(); // HashMap을 정의
        for (int i = 0; i < N; i++) {
            sets.put(br.readLine(), 0); // HashMap에 키값으로 입력받은 문자열들을 추가. value에는 0을 추가.
        }
        String[] inspections= new String[M];
        for (int j = 0; j < M; j++) {
            inspections[j] = br.readLine(); // 검사해야하는 문자열을 inspections에 담아 줌.
        }

        for (int k = 0; k < M; k++) {
            if(sets.get(inspections[k]) != null){ // 검사해야할 것들을 집합 S(HashMap)에서 불러왔는데 null이 아니라면(정의되었다면)
                result++;
            }
        }


        System.out.println(result);


    }
}
