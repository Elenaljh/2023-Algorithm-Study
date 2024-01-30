/*
https://www.acmicpc.net/problem/5430
스터디 필수
 */
import java.io.*;
import java.util.*;

public class B5430 {
   static LinkedList<String> list;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());

      for (int i = 0; i < t; i++) {
         //1. 입력받기
         String commands = br.readLine();
         int numSize = Integer.parseInt(br.readLine());
         list = makeList(br.readLine(), numSize);


         //2. 로직 실행
         System.out.println(work(commands));

      }
   }

   static LinkedList<String> makeList(String str, int n) {
      LinkedList<String> tmp = new LinkedList<>();
      String[] nums = str.substring(1, str.length()-1).split(",");
      for (int i = 0; i < n; i++) {
         tmp.addLast(nums[i]);
      }
      return tmp;
   }

   static StringBuilder work(String commands) {
      StringBuilder sb = new StringBuilder();
      boolean front = true;
      for (int i = 0; i < commands.length(); i++) {
         char command = commands.charAt(i);
         if (command == 'R') {
            front = !front;
         }
         if (command == 'D' && list.isEmpty()) {
            sb.append("error");
            return sb;
         }
         if (command == 'D' && front) {
            list.pollFirst();
         }
         if (command == 'D' && !front) {
            list.pollLast();
         }
      }
      sb.append("[");
      int size = list.size();
      if (front) {
         for (int i = 0; i < size; i++) {
            sb.append(list.pollFirst()).append(",");
         }
      } else {
         for (int i = 0; i < size; i++) {
            sb.append(list.pollLast()).append(",");
         }
      }
      if (sb.charAt(sb.length()-1) == ',') {
         sb.deleteCharAt(sb.length()-1);
      }
      sb.append("]");
      return sb;
   }

}
