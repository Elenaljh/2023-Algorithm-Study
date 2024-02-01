package 과제;

/*
https://www.acmicpc.net/problem/11723
집합
 */
public class B11723 {
    static int S;
    public static void main(String[] args) {
        S = 0;
    }

    static void bit(String str) {
        /**
         * add : S | (1<<x)
         * remove : S & ~(1<<x)
         * check : S & (1<<x)
         * toggle : S ^ (1<<x)
         * all : S = (1<<20)-1
         * empty : S = 0
         */
    }
}
