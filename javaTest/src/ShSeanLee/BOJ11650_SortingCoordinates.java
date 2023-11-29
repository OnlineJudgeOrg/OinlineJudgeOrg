package ShSeanLee;

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
        int arr[][] = new int[N][2]; // N행 2열의 이중 배열
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) { // 연속적으로 받아서 이중 배열에 대입하는 과정
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){ // 인접한 두 좌표의 비교
                System.out.println("o2 : " + o2[0]);
                System.out.println("o1 : " + o1[0]);
                System.out.println();
                if (o1[0] == o2[0]){ // x값이 같을 때는 - 원시타입이 아닌 Integer이기 때문에 equals로 비교. - ArrayList의 <> 아닐 때에는 int로 대부분 가능!!
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
