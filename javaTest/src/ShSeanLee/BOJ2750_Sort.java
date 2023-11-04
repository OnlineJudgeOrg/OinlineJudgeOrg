package ShSeanLee;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ2750_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        int N = Integer.parseInt(br.readLine());
        int tmp = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            nums.add(tmp);
        }
//        System.out.println(nums);
        nums.sort(Comparator.naturalOrder());
        for (int num : nums) {
            bw.write(Integer.toString(num) + "\n");
        }
        bw.close();
    }
}
