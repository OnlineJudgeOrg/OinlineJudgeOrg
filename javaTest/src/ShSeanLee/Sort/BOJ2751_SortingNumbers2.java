package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class BOJ2751_SortingNumbers2 { // sort를 쓰는 방법 매우느림 (2572ms)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        String[] str = br.readLine().split("\n");
        Integer[] numbers = new Integer[N]; // int로 돌리는것 - 1764ms, 1560ms - int로 웬만하면 됨, ArrayList제외



        for (int i = 0; i < numbers.length; i++) {
            String tmp = br.readLine();
            numbers[i] = Integer.parseInt(tmp); // 형 변환해서 배열에 담기.
        }

        Arrays.sort(numbers);

        for (int j = 0; j < numbers.length; j++) {
            bw.write(numbers[j] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
