package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

/*
Deque과 ArrayDeque을 활용한 풀이 (1444ms)
 */


public class BOJ18258_Queue2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
//                    System.out.println("push");
                    String tmp = st.nextToken();
                    queue.addLast(tmp);
                    break;

                case "pop" :
//                    System.out.println("pop");
                    if (queue.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.removeFirst()).append("\n");
                    }
                    break;


                case "size" : sb.append(queue.size()).append("\n");
//                    System.out.println("size");
                    break;


                case "empty" :
//                    System.out.println("empty");

                    if (queue.isEmpty()){
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;

                case "front" :
//                    System.out.println("front");
//                    System.out.println(queue);
                    if (queue.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;

                case "back" :
//                    System.out.println("back");
//                    System.out.println(queue);

                    if (queue.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;

            }
        }


        System.out.println(sb);

    }

//    public static String peekLast(Queue<String> queue){
//        String tmp = null;
//        while(!queue.isEmpty()){
//            tmp = queue.poll();
//        }
//        return tmp;
//
//    }
}
