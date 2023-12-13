package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ28278_Stack2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 956ms(Deque), 1036ms(Stack)
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>(); // 42% 시간초과 - 조금 더 나은 성능
//        Stack<Integer> stack = new Stack<>(); // 34% 시간초과
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.length() >= 2){ // 길이가 2이면 두번째 숫자를 push해야함
                StringTokenizer st = new StringTokenizer(tmp);
//                System.out.println(tmp);
                String n1 = st.nextToken();
                stack.addFirst(Integer.parseInt(st.nextToken()));
//                stack.push(Integer.parseInt(st.nextToken())); // stack
//                System.out.println(stack);
            } else {
                orders(stack, Integer.parseInt(tmp), sb);
//                orders2(stack, Integer.parseInt(tmp), sb);
            }

        }
        System.out.println(sb);

    }



    public static void orders(Deque stack, int number, StringBuilder sb){
        if (number == 2){
            if (!stack.isEmpty()){
                sb.append(stack.pop()+"\n");
            } else {
                sb.append("-1"+"\n");
            }
        } else if (number == 3){
            sb.append(stack.size()+"\n");

        } else if (number == 4){
            if (stack.isEmpty()){
                sb.append("1"+"\n");
            } else {
//                System.out.println(stack.isEmpty()); // 메소드 오버로딩 필요
                sb.append("0"+"\n");

            }
        } else {
            if (!stack.isEmpty()){
                sb.append(stack.peekFirst()+"\n");

            } else {
                sb.append("-1"+"\n");

            }
        }
    }


//    public static void orders2(Stack stack, int number, StringBuilder sb){
//        if (number == 2){
//            if (!stack.isEmpty()){
//                sb.append(stack.pop()+"\n");
//            } else {
//                sb.append("-1"+"\n");
//            }
//        } else if (number == 3){
//            sb.append(stack.size()+"\n");
//
//        } else if (number == 4){
//            if (stack.isEmpty()){
//                sb.append("1"+"\n");
//            } else {
////                System.out.println(stack.isEmpty()); // 메소드 오버로딩 필요
//                sb.append("0"+"\n");
//
//            }
//        } else {
//            if (!stack.isEmpty()){
////                System.out.println(stack.peekFirst());
//                sb.append(stack.lastElement()+"\n");
//
//            } else {
////                System.out.println(-1);
//                sb.append("-1"+"\n");
//
//            }
//        }
//    }



}
