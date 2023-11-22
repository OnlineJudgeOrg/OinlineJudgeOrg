package ShSeanLee;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785_IsInCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> names = new HashSet<>(); // 이름들을 받는 Hashset
        ArrayList IsInCor = new ArrayList<String>(); // 회사에 있는 사람의 이름을 받음
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> logs = new HashMap<>(); // HashMap으로 풀리지 않는 이유는, 중복되는 이름(key)이 들어와도 해당 값(value)을 바꾸지 않는다는 것에 있음.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken(); // 이름
            names.add(key); // 이름들을 받는
            logs.put(key, st.nextToken()); // 이름을 key로, 출퇴근 여부를 value로
        }
//        System.out.println(names);
        for (String name : names) {
            if(logs.get(name).equals("enter")){ // 한명씩 이름으로 불러와서 그 value(상태)가 enter면,
                IsInCor.add(name); //회사에 있는 사람 목록에 추가
            }
        }

        Collections.sort(IsInCor, new Comparator<String>(){ // 사전 역순으로 출력해야 하므로, 내림차순 구현!
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1); // String의 정렬은 compareTo로 해야함!!
            }
        });
//        System.out.println(logs.get("Baha"));
        for (int i = 0; i < IsInCor.size(); i++) {
//            System.out.println(IsInCor.get(i)); // sb 안썼을 떄는 1596ms의 효율
            sb.append(IsInCor.get(i)).append('\n'); // 썼을 때는 804ms의 효율
        }
        System.out.println(sb);

    }
}
