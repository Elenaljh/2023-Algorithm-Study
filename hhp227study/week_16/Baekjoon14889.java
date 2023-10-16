/**
스타트와 링크
https://www.acmicpc.net/problem/14889
*/

import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arrays = new int[n][n];
        Set<Integer> numbers = new HashSet<>() { { for (int i = 0; i < n; i++) add(i); } };

        Arrays.setAll(arrays, value -> {
            int[] arr = new int[n];

            Arrays.setAll(arr, i -> scanner.nextInt());
            return arr;
        });
        combination(new Stack<>(), n, arrays, numbers, 0);
        System.out.println(answer);
        scanner.close();
    }

    private static void combination(Stack<Integer> stack, int n, int[][] arrays, Set<Integer> numbers, int start) {
        for (int i = start; i < n; i++) {
            if (stack.contains(i)) continue;
            stack.push(i);
            if (stack.size() < n / 2) combination(stack, n, arrays, numbers, i);
            else answer = Math.min(answer, getSubtractSum(Set.of(new HashSet<>(stack), new HashSet<>(numbers) { { removeAll(stack); }}), arrays));
            stack.pop();
        }
    }

    private static int getSubtractSum(Set<Set<Integer>> lists, int[][] array) {
        Iterator<Set<Integer>> it = lists.iterator();
        List<Integer> first = new ArrayList<>(it.next());
        List<Integer> last = new ArrayList<>(it.next());
        int firstSum = combinationSum(first, array);
        int lastSum = combinationSum(last, array);
        return Math.max(firstSum, lastSum) - Math.min(firstSum, lastSum);
    }

    private static int combinationSum(List<Integer> sliced, int[][] array) {
        int result = 0;

        for (int i = 0; i < sliced.size() - 1; i++) {
            for (int j = i + 1; j < sliced.size(); j++) {
                result += array[sliced.get(i)][sliced.get(j)];
                result += array[sliced.get(j)][sliced.get(i)];
            }
        }
        return result;
    }
}
