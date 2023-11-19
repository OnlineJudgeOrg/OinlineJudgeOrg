import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785_IsInCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> names = new HashSet<>();
        ArrayList IsInCor = new ArrayList<String>();
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> logs = new HashMap<>(); // HashMap으로 풀리지 않는 이유는, 중복되는 이름이 들어와도 해당 놈을 바꾸지 않는다는 것에 있음.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            names.add(key);
            logs.put(key, st.nextToken());
        }
//        System.out.println(names);
        for (String name : names) {
            if(logs.get(name).equals("enter")){
                IsInCor.add(name);
            }
        }

        Collections.sort(IsInCor, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
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
