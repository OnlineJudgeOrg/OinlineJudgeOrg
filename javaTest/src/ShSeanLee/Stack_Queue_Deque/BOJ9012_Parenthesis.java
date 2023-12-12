package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
public class BOJ9012_Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            checkingVPS(ps);
        }
    }
    
    public static void checkingVPS(String ps){
        int cnt = 0;
        for (int i = 0; i < ps.length(); i++) {
            String p = ps.substring(i, i+1);
            if(p.equals("(")){
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0){
                System.out.println("NO");
                break;
            }
        }
        if (cnt == 0){
            System.out.println("YES");
        } else if (cnt > 0){
            System.out.println("NO");
        }

    }
}
    
//    public static void checkingVPS(String ps){
//        Deque<String> stack = new ArrayDeque<>();
////        Deque<String> stack2 = stack;
//        int rept = ps.length();
//        System.out.println(rept);
//        for (int i = 0; i < rept; i++) {
//            String p = ps.substring(i, i+1);
//            System.out.println(p);
//            if (p.equals("(")){
//                stack.addFirst("(");
//            } else { // ")"
//                if (stack.isEmpty()){
//                    break;
//                } else {
//                    if(stack.peekFirst().equals("(")){
//                        stack.removeFirst();
//                    }
//
//                }
//            }
//            System.out.println(stack.toString());
//
//        }
//        System.out.println("--");
//        System.out.println(stack.toString());
//        answer(stack);
//
//    }
//    public static void answer(Deque stack){
//        if(stack.isEmpty()){
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//    }
//}
