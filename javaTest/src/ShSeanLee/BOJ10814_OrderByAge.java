import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ10814_OrderByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[][] info = new String[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = st.nextToken(); // 나이 담기
            info[i][1] = st.nextToken(); // 이름 담기
            info[i][2] = Integer.toString(i); // 순번 담기
        }

        Arrays.sort(info, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])){ // 나이가 같으면,
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); // 순번으로 비교
                } else { // 기본은 나이로 비교
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for (int j = 0; j < N; j++) {
            sb.append(info[j][0] + " " + info[j][1]).append("\n");
        }

        System.out.println(sb);

    }
}
