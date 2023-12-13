package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10773_Zero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                stack.removeFirst(); // pop
            } else {
                stack.addFirst(num); // push
            }
        }
//        System.out.println(stack.toString());
        int sum = 0;
//        System.out.println(stack.size());
        int rept = stack.size();

        for (int i = 0; i < rept; i++) {
            sum += stack.removeFirst(); // removeFirst는 Stack에서 가장 위의 수를 return하며 제거한다.
        }
        System.out.println(sum);

    }
}
