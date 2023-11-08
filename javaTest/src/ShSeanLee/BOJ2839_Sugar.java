package ShSeanLee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ2839_Sugar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = -1;
        // 5로 나눈 몫을 기준으로 for문을 큰 수 부터 돌림
        int iMax = N / 5; // 5로만 배달한다고 가정했을 때 최대 값
        int jMax = N / 3; // 3으로만 배달한다고 가정했을 때 최대 값
        int i = 0;
        int j = 0;
        for (i = iMax; i >= 0; i--) { // 3 * j + 5 * i = N
//            for (int j = 0; j <= (N - 5 * i) / 3; j++) {
            for (j = jMax; j >= 0; j--) {
//                System.out.println(j + ", " + i);
                if(3*j + 5*i == N){
//                    result = Math.min(result, i + j); -> 왜 이렇게 미니멈 때리면 87%에서 안될지 생각해보기
                    result = i + j;
//                    System.out.println(i + " " + j);
                    break;
                }
            }
            if (3*j + 5*i == N){ // 첫번째 for문도 같이 탈출하기
                break;
            }
        }
//        if (result == 10000){
//            bw.write("-1" + "\n");
//        } else {
        bw.write(result + "\n");
        bw.flush();
        bw.close();
//        }
//        System.out.println(result);



    }
}

