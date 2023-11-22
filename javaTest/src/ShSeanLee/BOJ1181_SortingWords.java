package ShSeanLee;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1181_SortingWords {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if (o1.length() == o2.length()){ // 길이가 같으면,
                    return o1.compareTo(o2); // 사전순으로, String의 정렬은 compareTo로 해야함!!
//                    return Integer.valueOf(o1) -Integer.parseInt(o2); // valueOf, parseInt 모두 불가!!
                } else { // 그외에는
                    return o1.length() - o2.length(); // 길이가 짧은것부터
                }
            }

        });

        for (int i = 0; i < N; i++) {
            if (i == 0){
                sb.append(arr[i]).append('\n'); // 첫번째 값은 뒤에 조건을 보지 않고 sb에 추가 후, i = 1로 넘어감.
                continue;
            }
            if (arr[i-1].equals(arr[i])){ // 정렬하고 나니 이전값과 같으면 그냥 넘김
//                continue;
            } else {
                sb.append(arr[i]).append('\n'); // 이전값과 다르면 sb에 추가.
            }
        }
        System.out.println(sb);

    }
}
