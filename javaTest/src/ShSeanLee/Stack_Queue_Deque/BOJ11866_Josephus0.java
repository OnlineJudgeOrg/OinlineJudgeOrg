package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
rotate를 구현하고, sb를 활용하여 원모양 queue 구현 (160ms)
 */

// 리뷰 1: deqeue에 다 꺼낼때 한개 남았을 때, 문제가 생긴다 -> 얘는 while 루프에 1보다 클때로 두고선, 1일 때는 자동으로 해결되게 한다.

public class BOJ11866_Josephus0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
//        boolean[] numbers = new boolean[N];
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            numbers.addLast(i); // 1~N 덱 구성
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!numbers.isEmpty()){ // 다 제거될 때 가지 반복
            // K-1번 rotate
            for (int i = 0; i < K-1; i++) {
                numbers.addLast(numbers.removeFirst()); // 첫째 값 제거해서, 마지막에 추가한다.
            }
            // K번째 pop
            sb.append(numbers.removeFirst()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1); // 마지막 공백 제거
        sb.setCharAt(sb.length() - 1, '>'); // 마지막 콤마 '>'로 바꾸기

        System.out.println(sb);
    }

}
