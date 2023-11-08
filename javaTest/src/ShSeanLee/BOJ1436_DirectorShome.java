package ShSeanLee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ1436_DirectorShome {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int NInt = Integer.parseInt(N);
        int cnt = 0;
        int i = 666; // 666부터 돈다.
        while(NInt != cnt) {
            if (Integer.toString(i).contains("666")){ // 666이 포함되는 것이라면,
//                System.out.println(i);
                cnt++;
            }
            i++; // 돌 숫자 하나씩 증가.

        }
        bw.write(Integer.toString(i-1) + "\n"); // cnt가 뒤에있으므로 결과 값은 -1 해준 값임.
        bw.flush();
        bw.close();

    }
}

