package 수업;

import java.util.Stack;

public class StackAPITest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty() + "//" + stack.size());
        stack.push("갓병찬");
        stack.push("자바의 신 전은수");
        stack.push("김동근");
        stack.push("닥터홍");
        stack.push("핑구");
        System.out.println(stack.isEmpty() + "//" + stack.size());
        System.out.println(stack.peek());

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
