package Set_Map;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ10815_NumberCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> result = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        String[] numsStr = br.readLine().split(" ");
        Integer[] numsIhave = new Integer[N]; // 가지고있는 카드를 담는 배열

        for (int i = 0; i < N; i++) {
            numsIhave[i] = Integer.parseInt(numsStr[i]);
        }
        Arrays.sort(numsIhave);


        int M = Integer.parseInt(br.readLine());
        String[] numsStr2 = br.readLine().split(" ");
        Integer[] numsSearch = new Integer[M]; // 탐색할 배열

        for (int j = 0; j < M; j++) {
            numsSearch[j] = Integer.parseInt(numsStr2[j]);
        }

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (numsSearch[m] == numsIhave[n]){ // 탐색하면서 해당 카드가 탐색할 배열에 있으면,
                    result.add(1); // 리스트에 1을 추가함.
                    break;
                }
            }
            if (result.size() < m+1){ // 끝까지 돌았으면 0을 추가해줌.
                result.add(0);
            }
        }
//        System.out.println(result);
        for (Integer r: result) {
            bw.write(String.valueOf(r));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
// Hash map과 Binary search의 관계

// 정답 - Hashmap을 이용한 풀이
// https://velog.io/@leetaekyu2077/%EC%9E%90%EB%B0%94-HashMap-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0-BOJ-10815-%EC%88%AB%EC%9E%90-%EC%B9%B4%EB%93%9C
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        int n, m;
//        HashMap<String, Integer> owned = new HashMap<>();
//
//        n = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i=0; i<n; i++) {
//            owned.put(st.nextToken(), 0);
//        }
//
//        m = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i=0; i<m; i++) {
//            if (owned.get(st.nextToken()) != null) { // 해당 번호의 key값이 정의되지 않은것이 아니라면, 즉 내가 가지고 있는 것이라면,
//                sb.append("1 ");
//            } else {
//                sb.append("0 ");
//            }
//        }
//        System.out.println(sb.toString()); // String으로 합쳐서 출력
//    }
//}