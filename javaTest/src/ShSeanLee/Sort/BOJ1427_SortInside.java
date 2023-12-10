package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427_SortInside {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 문자를 이어붙여서 출력하기 위한 StringBuilder 객체 생성
        String[] nums = br.readLine().split("");
        Arrays.sort(nums, Collections.reverseOrder()); // 내림차순으로 정렬

        for (String ii: nums) {
            sb.append(ii); // StringBuilder에 이어 담기
        }
        System.out.println(sb.toString()); // 이어붙이기
    }
}
