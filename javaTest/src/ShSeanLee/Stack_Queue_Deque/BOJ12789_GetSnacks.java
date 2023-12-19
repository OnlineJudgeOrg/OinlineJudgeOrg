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
        for (int i = 1; i < N+1; i++) { // 1~N까지의 순서
//            System.out.println(i);
            while(true){ // i를 찾는 과정 무한 반복
//                System.out.println(stack);
                if (!stack.isEmpty()){
                    if (stack.peekFirst() == i){ // stack의 첫번째 값이 i면,
                        stack.removeFirst(); // 해당 i값을 찾은 것이므로, 걔를 제거하고 다음 숫자로 넘어감.
                        break;
                    }
                }
                if (q.isEmpty() & !stack.isEmpty()){ // q가 비었고, 스택에 숫자가 하나라도 있는데,
                    if (stack.peekFirst() != i) { // 그 스택의 값이 i가 아니라면
                        System.out.println("Sad"); // 더 이상 찾을 수 있는게 없으므로
                        break loop1;
                    }
                }
                int tmp = q.poll();
                if (tmp != i) { // q에서 뽑은 값이 i와 같지 않을 때는,
                    stack.addFirst(tmp); // stack에 옮겨담기
                } else { // 같으면 찾은 것이기에 while문 종료
                    break;
                }

            }

        }
        if (q.isEmpty() & stack.isEmpty()){ // for문이 종료되고 q와 stack모두 비어있을때만 nice
            System.out.println("Nice");
        }

        
    }
}
