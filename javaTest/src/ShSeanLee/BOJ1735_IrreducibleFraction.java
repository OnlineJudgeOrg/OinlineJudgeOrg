import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;



public class BOJ1735_IrreducibleFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int GreatestDivisor = getGCDivisor(arr[0][1], arr[1][1]);
        int restNumber1 = arr[0][1]/GreatestDivisor;
        int restNumber2 = arr[1][1]/GreatestDivisor;
        int upper = restNumber2 * arr[0][0] + restNumber1 * arr[1][0];
        int lower = restNumber2 * arr[0][1];

        int GD = getGCDivisor(upper, lower); // 기약분수이므로!

        System.out.println(upper/GD + " " + lower/GD);


    }

    public static int getGCDivisor(int number1, int number2){
        HashSet<Integer> Divisor1 = getDivisor(number1);
        HashSet<Integer> Divisor2 = getDivisor(number2);
        Divisor1.retainAll(Divisor2);
        return getMax(Divisor1);
    }

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
