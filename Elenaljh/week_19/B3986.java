import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        while(n-- > 0) {
            Stack<Character> stk = new Stack<>();
            String str = br.readLine();
            boolean isGood = true;

            int len = str.length();
            for(int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if(stk.isEmpty()) {
                    stk.push(ch);
                }else {
                    if(stk.peek() == ch) {
                        stk.pop();
                    }else {
                        stk.push(ch);
                    }
                }
            }
            if(stk.isEmpty()) ans += 1;
        }
        System.out.println(ans);
    }
}
