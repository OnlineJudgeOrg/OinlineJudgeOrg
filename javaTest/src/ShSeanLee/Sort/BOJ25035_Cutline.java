package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ25035_Cutline {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] Nk= br.readLine().split(" ");
        int N = Integer.parseInt(Nk[0]); // 응시자수 N명
        int k = Integer.parseInt(Nk[1]); // 상을받는 k명

        String[] str = br.readLine().split(" ");
        Integer[] intArr = new Integer[N];

        for (int i = 0; i < str.length; i++) {
            intArr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(intArr);

        bw.write(intArr[N-k] + "\n"); // 1 2 3 4 5(N)명 중에서 -k 번째 사람까지 - 오름차순이므로.
        bw.flush();
        bw.close();

    }
}
