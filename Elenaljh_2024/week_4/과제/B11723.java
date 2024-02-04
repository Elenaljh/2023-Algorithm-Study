package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11723
집합
 */
public class B11723 {
    static int S, x = 0;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        S = 0;

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            S = bit(tmp);
        }

        System.out.println(sb);

    }

    static int bit(String str) {
        /**
         * add : S | (1<<x)
         * remove : S & ~(1<<x)
         * check : S & (1<<x)
         * toggle : S ^ (1<<x)
         * all : S = (1<<20)-1
         * empty : S = 0
         */
        st = new StringTokenizer(str);
        String command = st.nextToken();
        if (!command.equals("all") && !command.equals("empty")) {
            x = Integer.parseInt(st.nextToken());
        }

        switch (command) {
            case "add":
                return S | (1<<(x-1));
            case "remove":
                return S & ~(1<<(x-1));
            case "check":
                sb.append((S&(1<<(x-1))) != 0 ? 1 : 0).append("\n");
                return S;
            case "toggle":
                return S ^ (1<<(x-1));
            case "all":
                return (1<<20)-1;
            case "empty":
                return 0;
        }
        return 0;
    }
}
