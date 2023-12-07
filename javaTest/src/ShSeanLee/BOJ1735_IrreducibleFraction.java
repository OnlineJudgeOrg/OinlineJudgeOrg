import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;


// 1735번 분수 합: 성공(2088ms)
public class BOJ1735_IrreducibleFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[2][2]; // 2차원 배열에 두 분수를 담음
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int GreatestDivisor = getGCDivisor(arr[0][1], arr[1][1]); // 분모의 최대공약수를 구함
        int restNumber1 = arr[0][1]/GreatestDivisor; // 첫 분모에서 두번째 분모와 분자에 곱할 값을 얻음
        int restNumber2 = arr[1][1]/GreatestDivisor; // 두번째 분모에서 첫번째 분모와 분자에 곱할 값을 얻음
        int upper = restNumber2 * arr[0][0] + restNumber1 * arr[1][0]; // 분자는 크로스로 곱해서 더함
        int lower = restNumber2 * arr[0][1]; // 분모는 한쪽만 곱해주면 됨

        int GD = getGCDivisor(upper, lower); // 기약분수이므로, 한번 더 최대공약수를 구함

        System.out.println(upper/GD + " " + lower/GD); // 최대공약수로 나오면 결국 기약분수가 된다.


    }

    // 최소공배수 구하는 메서드
    public static int getGCDivisor(int number1, int number2){
        HashSet<Integer> Divisor1 = getDivisor(number1);
        HashSet<Integer> Divisor2 = getDivisor(number2);
        Divisor1.retainAll(Divisor2);
        return getMax(Divisor1);
    }
    
    // 약수의 집합을 구하는 메서드
    public static HashSet<Integer> getDivisor(int number){
        HashSet<Integer> set = new HashSet<>();
        if (number == 1){
            set.add(1);
        } else {
            for (int i = 1; i < number / 2 + 1; i++) {
                if (number % i == 0) {
                    set.add(i);
                    set.add(number / i);
                }
            }
        }
        return set;
    }

    // 배열에서 최댓값을 구하는 메서드
    public static int getMax(HashSet<Integer> set){
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        int max = 1;
        for (int i = 0; i < set.size(); i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

}
