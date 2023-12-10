package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class BOJ11478_DifferentString {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i < str.length() + 1; i++) { // 부분집합의 길이
            for (int j = 0; j < str.length() - i + 1; j++) { // 문자열을 끝까지 탐색 ex: i=2일때(부분집합의 길이가 2), 5의 문자열 길이에서 4까지 탐색함.
                set.add(str.substring(j, j+i)); // 마지막을 포함하지 않으므로 +1
            }
        }

        System.out.println(set.size());


    }
}
