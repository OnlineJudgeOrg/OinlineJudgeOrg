import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BOJ14425_StringSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> sets = new HashMap<>();
        for (int i = 0; i < N; i++) {
            sets.put(br.readLine(), 0);
        }
        String[] inspections= new String[M];
        for (int j = 0; j < M; j++) {
            inspections[j] = br.readLine();
        }

        for (int k = 0; k < M; k++) {
            if(sets.get(inspections[k]) != null){
                result++;
            }
        }


        System.out.println(result);


    }
}
