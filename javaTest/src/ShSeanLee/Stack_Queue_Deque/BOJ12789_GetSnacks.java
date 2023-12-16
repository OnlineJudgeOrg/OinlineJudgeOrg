package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
임시칸 Stack을 활용한 문제 (136ms)
 */

public class BOJ12789_GetSnacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>(); // 임시로 대기하는 공간

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        loop1:
        for (int i = 1; i < N+1; i++) {
//            System.out.println(i);
            while(true){
//                System.out.println(stack);
                if (!stack.isEmpty()){
                    if (stack.peekFirst() == i){ // stack의 첫번재 값이 i면,
                        stack.removeFirst();
                        break;
                    }
                }
                if (q.isEmpty() & !stack.isEmpty()){
                    if (stack.peekFirst() != i) {
                        System.out.println("Sad");
                        break loop1;
                    }
                }
                int tmp = q.poll();
                if (tmp != i) {
                    stack.addFirst(tmp);
                } else {
                    break;
                }

            }

        }
        if (q.isEmpty() & stack.isEmpty()){
            System.out.println("Nice");
        }

        
    }
}
