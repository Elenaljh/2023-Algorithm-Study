/**
분해합
https://www.acmicpc.net/problem/2231
*/

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long answer = IntStream.range(0, number).takeWhile(operand -> operand + Arrays.stream(String.valueOf(operand).split("")).mapToInt(Integer::valueOf).sum() != number).count();
        
        System.out.println(answer == number ? 0 : answer);
        scanner.close();
    }
}
