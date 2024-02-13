package 스터디;
/*
단어의 개수
https://www.acmicpc.net/problem/1152
 */
import java.util.*;
import java.io.*;
public class B1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.strip();
        if (str.equals("")) {
            System.out.println(0);
            return;
        }
        String[] strs = str.split(" ");
        System.out.println(strs.length);
    }
}
