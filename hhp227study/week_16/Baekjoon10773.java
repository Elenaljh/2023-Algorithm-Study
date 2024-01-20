/**
제로
https://www.acmicpc.net/problem/10773
*/

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        int input = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
      
        scanner.nextLine();
        for (int i = 0; i < input; i++) {
            int number = scanner.nextInt();
            
            if (number != 0) stack.push(number);
            else stack.pop();
            scanner.nextLine();
        }
        for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext();)
            answer += iterator.next();
        System.out.println(answer);
    }
}
