package ShSeanLee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class BOJ10989_SortingNumbers3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
//        ArrayList<Integer> numbers = new ArrayList<>();
        Integer[] numbers = new Integer[N]; // 얘를 int로 바꾸니까 메모리초과 해결됨.

        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int tmp = Integer.parseInt(st.nextToken());
//            int tmp = Integer.parseInt(br.readLine());
//            numbers[i] = tmp;
            numbers[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(numbers);
//        Collections.sort(numbers);
//        for (int p: numbers) {
//            sb.append(p).append('\n');
////            System.out.println(p);
////            bw.write(Integer.toString(p) + "\n");
////            bw.flush();
//        }
        for(int i = 0; i < N; i++){
            sb.append(numbers[i]).append('\n');
        }
//
        System.out.println(sb);
//        bw.close();


    }
}

// 풀이1) Arrays.sort()를 이용한 풀이 - 2584ms
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Arrays;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//
//        for(int i = 0; i < N; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        for(int i = 0; i < N; i++){
//            sb.append(arr[i]).append('\n');
//        }
//
//        System.out.println(sb);
//    }

// 풀이 2) 카운티정렬을 사용한 방법 - 1720ms
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        // 수의 범위 (0 ~ 10000) 사실상 0은 제외
//        int[] cnt = new int[10001];
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            // 해당 인덱스의 값을 1 증가
//            cnt[Integer.parseInt(br.readLine())] ++; [0, 0, 0, 0, ... ]
//        }
//
//        br.close();
//
//        StringBuilder sb = new StringBuilder();
//
//        // 0은 입력범위에서 없으므로 1부터 시작
//        for(int i = 1; i < 10001; i++){
//            // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
//            while(cnt[i] > 0){
//                sb.append(i).append('\n');
//                cnt[i]--;
//            }
//        }
//        System.out.println(sb);
//    }
//}