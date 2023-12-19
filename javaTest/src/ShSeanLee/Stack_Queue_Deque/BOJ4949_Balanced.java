package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
//import java.util.HashMap;
import java.util.Deque;
/*
괄호를 활용한 스택의 확장문제 (268ms)
 */
public class BOJ4949_Balanced {
    public static void main(String[] args) throws IOException{ // HashMap 활용법에 대한 연구 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String sentence = br.readLine();
            if (sentence.equals(".")){ // 정지조건
                System.out.println(sb);
                break;
            } else {
                sb.append(checker(sentence)).append("\n");
            }
        }

    }

    public static String checker(String sentence){
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < sentence.length(); i++) {
            String tmp = sentence.substring(i, i + 1);
            if (tmp.equals("(") || tmp.equals("[")) { // 괄호 시작하는 애들은 stack에 넣기
                stack.addFirst(tmp);
            } else if (stack.size() != 0){ // stack이 비어있지 않을 때는, 닫는 괄호 일때는 스택의 마지막 값이 열린 괄호일때만 제거, 아니면 넣어버리기
                if (tmp.equals(")")) { 
                    if (stack.peekFirst().equals("(")) {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(tmp);
                    }
                } else if (tmp.equals("]")) {
                    if (stack.peekFirst().equals("[")) {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(tmp);
                    }
                }
            } else if (tmp.equals(")") || tmp.equals("]")) { //스택이 비어있을 때는 닫는 괄호도 넣기.
                stack.addFirst(tmp);
                break;
            }

        }
//        System.out.println(stack);

        if (stack.size() == 0){ // 빈 스택일때는 yes를 스택이 차있을때눈 no
            return "yes";
        } else {
            return "no";
        }

    }

}

