package ShSeanLee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class BOJ1018_Chess { // 이 문제의 두가지 포인트: 1-> min을 구할꺼니 초기화를 가능한 최대 수로 한다. 2-> 함수 public static int counting 이런 식으로 한다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        String[][] arr = new String[M][N];
        for (int m = 0; m < M; m++) {
            arr[m] = br.readLine().split("");
        }

        // 시작점을 표시하는 루프

        int minResult = M * N;
        for (int s_j = 0; s_j < M - 7; s_j++) {
            for (int s_i = 0; s_i < N - 7; s_i++) {

                //들어갈 자리
                int cnt1 = counting(arr, s_j, s_i);
                minResult = Math.min(minResult, cnt1);
//                System.out.println(minResult);
            }



        }

        bw.write(minResult + "\n");
        bw.flush();
        bw.close();
    }


    public static int counting(String[][] board, int s_j, int s_i) { // 배열을 넣고, 첫번째 좌표를 받아서 카운팅을 해주는 함수
        String firstCharacter = board[0][0];
        int changeOriginal = 0;
        int changeReverse = 0;
        int result = 0;
        for (int j = s_j; j < s_j + 8; j++) { // s_j부터 행을 돌면서
            // 경우1) 첫 값이 W인 경우라고 가정하고, B는 걔 제외 나머지를 나 바꾸는 것으로 하여 M*N-cnt
//                        System.out.println(j);
            for (int i = s_i; i < s_i + 8; i++) { // i는 열의 번호 - s_i부터 열을 돌면서

                if ((j + i) % 2 == 0) { // 짝수이면,
                    if (board[j][i].equals(firstCharacter)) { // 0, 2, 4 행은 WBWB, 1, 3, 5행은 BWBW
                        changeReverse += 1;
                    } else {
                        changeOriginal += 1;
                    }
                } else { // 홀수이면
                    if (board[j][i].equals(firstCharacter)) { // 0, 2, 4 행은 WBWB, 1, 3, 5행은 BWBW
                        changeOriginal += 1;
                    } else {
                        changeReverse += 1;
                    }


                }
            }
//        System.out.println(changeReverse+" "+changeOriginal);
            result = Math.min(changeReverse, changeOriginal);

        }
        return result;
    }
}


//
//for (int j = s_j; j < s_j + 8; j++) { // s_j부터 행을 돌면서
//        // 경우1) 첫 값이 W인 경우라고 가정하고, B는 걔 제외 나머지를 나 바꾸는 것으로 하여 M*N-cnt
////                        System.out.println(j);
//        if (arr[s_j][s_i].equals("W")){ // 0, 2, 4 행은 WBWB, 1, 3, 5행은 BWBW
//        System.out.println("WBWB");
//        for (int i = s_i; i < s_i + 8; i++){ // i는 열의 번호 - s_i부터 열을 돌면서
////                        System.out.println(j);
//        if ((j-s_j)%2 == 0 ){ // WBWB 해야할 놈들
//        if ((i-s_i)%2 == 0 ){ // 짝수번째 열일 때
////                                    System.out.println(Integer.toString(j) + " " + Integer.toString(i));
////                            System.out.println(i);
//        if (arr[j][i].equals("B")){
//        cnt1 += 1;
//        System.out.println("W여야 했던 것 - 1");
//        }
//        } else if (arr[j][i].equals("W")){ // 홀수일때
//        System.out.println("B여야 했던 것 - 2");
//        cnt1 += 1;
//        }
//        } else { // BWBW 해야할 놈들
//        if ((i-s_i)%2 == 0 ){
////                                    System.out.println(Integer.toString(j) + " " + Integer.toString(i));
////                            System.out.println(i);
//        if (arr[j][i].equals("W")){
//        cnt1 += 1;
//        System.out.println("B여야 했던 것 -3 ");
//        }
//        } else if (arr[j][i].equals("B")){ // 홀수일때
//        cnt1 += 1;
//        System.out.println("W여야 했던 것 - 4");
//        }
//        }
//
//
//        }
//        counts.add(cnt1);
//
////                        tmp0 = Math.min(tmp0, cnt1);
//        System.out.println(cnt1);
//
//
//        } else{
//        System.out.println("BWBW");
//        for (int i = s_i; i < s_i + 8; i++){ // i는 열의 번호 - s_i부터 열을 돌면서
////                        System.out.println(j);
//        if ((j-s_j)%2 == 0 ){ // BWBW 해야할 놈들
//        if ((i-s_i)%2 == 0 ){ // 짝수번째 열일 때
//        System.out.println(Integer.toString(j) + " " + Integer.toString(i));
////                            System.out.println(i);
//        if (arr[j][i].equals("W")){
//        cnt1 += 1;
//        System.out.println("B여야 했던 것 - 1");
//        }
//        } else if (arr[j][i].equals("B")){ // 홀수일때
//        System.out.println("W여야 했던 것 - 2");
//        cnt1 += 1;
//        }
//        } else { // WBWB 해야할 놈들
//        if ((i-s_i)%2 == 0 ){
//        System.out.println(Integer.toString(j) + " " + Integer.toString(i));
////                            System.out.println(i);
//        if (arr[j][i].equals("B")){
//        cnt1 += 1;
//        System.out.println("W여야 했던 것 -3 ");
//        }
//        } else if (arr[j][i].equals("W")){ // 홀수일때
//        cnt1 += 1;
//        System.out.println("B여야 했던 것 - 4");
//        }
//        }
////                            tmp0 = Math.min(tmp0, cnt1);
//        counts.add(cnt1);
//        System.out.println(cnt1);
//        }
//
//
//        }
//
//
//
//
////                    System.out.println(tmp0);
//        // 경우2) 첫 값이 B인 경우 -> 전체 갯수 - 원래갯수
//
//
//
//        }
