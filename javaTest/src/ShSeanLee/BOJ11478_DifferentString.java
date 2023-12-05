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
            for (int j = 0; j < str.length() - i + 1; j++) {
                set.add(str.substring(j, j+i));
            }
        }

        System.out.println(set.size());


    }
}
