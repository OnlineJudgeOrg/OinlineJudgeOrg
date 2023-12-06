import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

// 13241번 최소공배수 : 성공(184ms)
public class BOJ13241_LeastCommonMultiple { // 1934번 최소공배수 문제와 풀이는 같고, int만 Long으로 변환
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long number1 = Integer.parseInt(st.nextToken());
        long number2 = Integer.parseInt(st.nextToken());
        long GreatestDivisor = getGCDivisor(number1, number2);
        long restNumber1 = number1/GreatestDivisor;
        long restNumber2 = number2/GreatestDivisor;
        System.out.println(GreatestDivisor * restNumber1 * restNumber2);
    }

    public static Long getGCDivisor(Long number1, Long number2){
        HashSet<Long> Divisor1 = getDivisor(number1);
        HashSet<Long> Divisor2 = getDivisor(number2);
        Divisor1.retainAll(Divisor2);
        return getMax(Divisor1);
    }

    public static HashSet<Long> getDivisor(Long number){
        HashSet<Long> set = new HashSet<>();
        if (number == (long)1){
            set.add((long)1);
        } else {
            for (int i = 1; i < number / 2 + 1; i++) {
                if (number % i == 0) {
                    set.add((long) i);
                    set.add(number / i);
                }
            }
        }
        return set;
    }

    public static Long getMax(HashSet<Long> set){
        Long[] arr = new Long[set.size()];
        set.toArray(arr);
        long max = 1;
        for (int i = 0; i < set.size(); i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
