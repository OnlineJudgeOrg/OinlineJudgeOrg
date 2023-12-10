package Bruteforce;// BOJ2798_BlackJack

import java.io.*;

public class BOJ2798_BlackJack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N장의 카드
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        String[] numbers = br.readLine().split(" ");
        int n = numbers.length;
        int[] num_int = new int[n];
        for (int i = 0; i < n; i++) {
            num_int[i] = Integer.parseInt(numbers[i]);
        }


//		Arrays.sort(num_int);
        int result = 0;

        if (M == 3) {
            result = num_int[0] + num_int[1] + num_int[2];
        } else {
            for (int i = 0; i < n - 2; i++) { // 투포인터  5 6 7 8 9
                int n1 = num_int[i];
                int sumOfTwo = 0;
                int sumOfThree = n1;
                for (int j = i+1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int sumTmp = n1 + num_int[j] + num_int[k];
                        if (sumTmp > N) {
                            continue;
                        } else {
                            sumOfThree = Math.max(sumOfThree, sumTmp);
                        }

                    }
                }
                result = Math.max(result, sumOfThree);


            }
        }



//		for (int i = 0; i < num_int.length; i++) {
//			bw.write(num_int[i]+"\n");
//			bw.flush();
//		}
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
