/**
외계인의 기타 연주
https://www.acmicpc.net/problem/2841
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), p = scanner.nextInt();
        Stack<Integer>[] stacks = new Stack[6];
        int count = 0;

        Arrays.setAll(stacks, i -> new Stack<>());
        for (int i = 0; i < n; i++) {
            int[] numbers = {scanner.nextInt(), scanner.nextInt()};
            Stack<Integer> stack = stacks[numbers[0] - 1];

            while (!stack.isEmpty() && stack.peek() > numbers[1]) {
                stack.pop();
                count++;
            }
            if (stack.isEmpty() || stack.peek() < numbers[1]) {
                stack.push(numbers[1]);
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
