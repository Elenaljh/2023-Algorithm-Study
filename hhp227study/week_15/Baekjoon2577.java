/**
숫자의 개수
https://www.acmicpc.net/problem/2577
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> map = Arrays.stream(String.valueOf(Arrays.stream(new int[] {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()}).reduce(1, (acc, i) -> acc * i)).split("")).collect(Collectors.groupingBy(i -> i));

        IntStream.rangeClosed(0, 9).map(val -> map.getOrDefault(String.valueOf(val), Collections.emptyList()).size()).peek(System.out::println).boxed().collect(Collectors.toList());
        scanner.close();
    }
}
