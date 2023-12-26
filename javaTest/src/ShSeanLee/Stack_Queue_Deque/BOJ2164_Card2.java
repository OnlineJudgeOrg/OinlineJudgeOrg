package Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
deque을 활용하여 queue를 구현하기. 99% 런타임에러와 틀렸습니다 반복 -> 1 예외처리를 따로 하지 않아서 발생 (212ms)
 */

public class BOJ2164_Card2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> card = new ArrayDeque<>();
        if (N == 1){
            System.out.println(1);
        } else {
            for (int i = 1; i < N+1; i++) {
                card.addLast(i); // [1, 2, 3, 4 .., N] 의 덱을 만드는 과정.
            }

            while (true){
                card.removeFirst(); // 우선 맨 위에 값 버림
                if (card.size() == 1){ // 하나 남았을 때는 첫번째 값 출력하고, break
                    System.out.println(card.peekFirst());
                    break;
                } else { // 여러개 있을 떄는 첫번재 값 제거하고 뒤에다가 둔다.
                    int tmp = card.removeFirst();
                    card.addLast(tmp);
                }
            }
        }



    }
}
