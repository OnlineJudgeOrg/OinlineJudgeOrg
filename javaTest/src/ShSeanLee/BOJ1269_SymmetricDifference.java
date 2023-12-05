import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;


public class BOJ1269_SymmetricDifference {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1Length = Integer.parseInt(st.nextToken());
        int s2Length = Integer.parseInt(st.nextToken());

        // ArrayList 3개 만드는 풀이 - 시간초과
//        ArrayList<Integer> s1 = new ArrayList<>();
//        ArrayList<Integer> s2 = new ArrayList<>();
//        ArrayList<Integer> intersection = new ArrayList<>();

        // Hashset 만드는 풀이 - 952ms
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        StringTokenizer setA = new StringTokenizer(br.readLine());
        for (int i = 0; i <s1Length; i++) {
            s1.add(Integer.parseInt(setA.nextToken()));
        }

        StringTokenizer setB = new StringTokenizer(br.readLine());
        for (int i = 0; i < s2Length; i++) {
            s2.add(Integer.parseInt(setB.nextToken()));
        }

        intersection.addAll(s1);
        intersection.retainAll(s2);
        s1.removeAll(intersection);
        s2.removeAll(intersection);
        System.out.println(s1.size() + s2.size());









    }
}
