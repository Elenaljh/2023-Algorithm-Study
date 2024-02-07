package 과제;

import java.io.*;
import java.util.*;
public class SW1228 {
    public static void main(String[] args) throws IOException {
        List<Integer> list;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int numOfCommands = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numOfCommands; j++) {
                if (st.nextToken().equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int k = 0; k < y; k++) {
                        list.add(x, Integer.parseInt(st.nextToken()));
                        x++;
                    }
                }
            }
            sb.append("#").append(i).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j)).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
