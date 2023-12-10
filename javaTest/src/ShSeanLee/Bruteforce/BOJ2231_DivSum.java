package Bruteforce;

import java.io.*;
import java.util.ArrayList;


public class BOJ2231_DivSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        if (N == 1){
//            System.out.println(result);
            bw.write(Integer.toString(result) + "\n");
            bw.flush();
        } else {
            for (int i = N/2; i < N; i++) {
                String[] strs = Integer.toString(i).split(""); // 한 글자씩 배열에 담는다.
                ArrayList<Integer> al = new ArrayList<>();
                for (int j = 0; j < strs.length; j++){
                    al.add(Integer.parseInt(strs[j]));
                }
                int sum = 0;
                for (int k = 0; k < strs.length; k++){
                    sum += al.get(k);
                }
                sum += i;

                if(sum == N){
                    result = i;
                    bw.write(Integer.toString(result) + "\n");
                    bw.flush();
//                    System.out.println(result);
//                    bw.close();
                    break;
                } else if (i == N-1){
                    bw.write(Integer.toString(result) + "\n");
                    bw.flush();
                }

            }
        }

        bw.close();

    }
}
