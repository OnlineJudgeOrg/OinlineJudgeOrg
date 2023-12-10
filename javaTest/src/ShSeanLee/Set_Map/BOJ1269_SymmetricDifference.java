package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

// 1269번 대칭차집합 성공(952ms)
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
        HashSet<Integer> intersection = new HashSet<>(); // 교집합을 위한 빈 HashSet을 만든다.

        StringTokenizer setA = new StringTokenizer(br.readLine());
        for (int i = 0; i <s1Length; i++) {
            s1.add(Integer.parseInt(setA.nextToken()));
        }

        StringTokenizer setB = new StringTokenizer(br.readLine());
        for (int i = 0; i < s2Length; i++) {
            s2.add(Integer.parseInt(setB.nextToken()));
        }

        intersection.addAll(s1); // s1을 담고
        intersection.retainAll(s2); // s1과 s2의 교집합을 결국 담는다.
        s1.removeAll(intersection); // s1의 차집합
        s2.removeAll(intersection); // s2의 차집합
        System.out.println(s1.size() + s2.size());









    }
}
