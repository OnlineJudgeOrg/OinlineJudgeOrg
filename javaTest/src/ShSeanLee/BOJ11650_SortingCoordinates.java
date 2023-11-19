import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ11650_SortingCoordinates {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer arr[][] = new Integer[N][2];
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){ // 인접한 두 좌표의 비교
                if (o1[0].equals(o2[0])){ // x값이 같을 때는
                    return o1[1] - o2[1]; // y값을 비교해서 출력
                } else { //  그외 에는
                    return o1[0] - o2[0]; // x값만 비교하면 충분하다.
                }
            }
        });



        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);

//        Collections.sort()



    }
}
