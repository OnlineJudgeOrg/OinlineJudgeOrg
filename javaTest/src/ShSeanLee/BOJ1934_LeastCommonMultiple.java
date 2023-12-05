import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;


public class BOJ1934_LeastCommonMultiple {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            int GreatestDivisor = getGCDivisor(number1, number2);
            int restNumber1 = number1/GreatestDivisor;
            int restNumber2 = number2/GreatestDivisor;

            sb.append(GreatestDivisor * restNumber1 * restNumber2).append("\n");
        }

        System.out.println(sb);

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
