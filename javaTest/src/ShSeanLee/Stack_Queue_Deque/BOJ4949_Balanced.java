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
            if (sentence.equals(".")){
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
            if (tmp.equals("(") || tmp.equals("[")) {
                stack.addFirst(tmp);
            } else if (stack.size() != 0){
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
            } else if (tmp.equals(")") || tmp.equals("]")) {
                stack.addFirst(tmp);
                break;
            }

        }
//        System.out.println(stack);

        if (stack.size() == 0){
            return "yes";
        } else {
            return "no";
        }

    }

}

