import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class BOJ1764_Unknown { // ArrayList 두개를 만들어서 했을 때는 시간초과!, set으로 했다가 결과만 ArrayList로 하고 정렬하니 344ms
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashSet<String> set1 = new HashSet<>();
//        ArrayList<String> list1 = new ArrayList<>(); // ArrayList 2개 만들기 list1
        for (int i = 0; i < N; i++) {
//            list1.add(br.readLine());
            set1.add(br.readLine());
        }

        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set2 = new HashSet<>();
//        ArrayList<String> list2 = new ArrayList<>(); // ArrayList 2개 만들기 list2
        for (int i = 0; i < M; i++) {
//            list2.add(br.readLine());
            set2.add(br.readLine());
        }

//        list1.retainAll(list2);
        set1.retainAll(set2);
//        Collections.sort(list1);
        ArrayList<String> al = new ArrayList<>(set1);
//        Collections.sort(al);
        Collections.sort(al, new Comparator<String>(){ // sort 오버라이드 연습
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }

        });


        StringBuilder sb = new StringBuilder();
        int size = al.size();
        for (int j = 0; j < size; j++) {
            sb.append(al.get(j)).append("\n");
        }



        System.out.println(size);
        System.out.println(sb);




    }
}
