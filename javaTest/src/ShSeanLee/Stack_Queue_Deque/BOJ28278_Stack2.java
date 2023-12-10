package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278_Stack2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.length() >= 2){
                StringTokenizer st = new StringTokenizer(tmp);
//                System.out.println(tmp);
                String n1 = st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
//                System.out.println(stack);
            } else {
                orders(stack, Integer.parseInt(tmp));
            }
        }

    }



    public static void orders(Stack stack, int number){
        if (number == 2){
            if (!stack.isEmpty()){
                System.out.println(stack.pop());
            } else {
                System.out.println(-1);
            }
        } else if (number == 3){
            System.out.println(stack.size());
        } else if (number == 4){
            if (stack.isEmpty()){
                System.out.println(1);
            } else {
//                System.out.println(stack.isEmpty()); // 메소드 오버로딩 필요
                System.out.println(0);
            }
        } else {
            if (!stack.isEmpty()){
                System.out.println(stack.lastElement());
            } else {
                System.out.println(-1);
            }
        }
    }



}
