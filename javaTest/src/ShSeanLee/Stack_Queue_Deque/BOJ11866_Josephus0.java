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

public class BOJ11866_Josephus0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
//        boolean[] numbers = new boolean[N];
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            numbers.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!numbers.isEmpty()){
            // K-1번 rotate
            for (int i = 0; i < K-1; i++) {
                numbers.addLast(numbers.removeFirst());
            }
            // K번째 pop
            sb.append(numbers.removeFirst()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(sb.length() - 1, '>');

        System.out.println(sb);
    }

}
