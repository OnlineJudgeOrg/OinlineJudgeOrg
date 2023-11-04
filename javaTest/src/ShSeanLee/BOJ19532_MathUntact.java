package ShSeanLee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class BOJ19532_MathUntact {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            nums.add(Integer.parseInt(strs[i]));
        }
        int x = 0;
        int y = 0;
        if (nums.get(0) == 0){ // a가 0일때, y값이 고정되어 있으므로 아래 값에다가 저장
//            System.out.println("yes");
            y = nums.get(2) / nums.get(1);
            x = (nums.get(5) - nums.get(4) * y) / nums.get(3);;
        } else{
            Integer[] numsMulArr = {nums.get(0) * nums.get(3), nums.get(1) * nums.get(3), nums.get(2) * nums.get(3),
                    nums.get(3) * nums.get(0), nums.get(4) * nums.get(0), nums.get(5) * nums.get(0)};
            ArrayList<Integer> numsMul = new ArrayList<>(Arrays.asList(numsMulArr));

            y = (numsMul.get(2) - numsMul.get(5)) / (numsMul.get(1) - numsMul.get(4)); //  y = (c-f)/(b-e)
            x = (numsMul.get(2) - numsMul.get(1) * y) / numsMul.get(0);
        } // by zero 런타임 에러 - 무수히 많다는 경우는 없음. 결국 a가 0인 경우에서 문제가 발생하는 것임



        bw.write(x + " " + y + "\n");
        bw.close();


    }
}
