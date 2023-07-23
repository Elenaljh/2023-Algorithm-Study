import java.util.*;

public class Main {
  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    map.put(1, sc.nextInt());
    int max = 1;
    for (int i = 2; i < 10; i++) {
      int N = sc.nextInt();
      map.put(i, N);
      if (map.get(max) < N) {max = i;}
    }
    System.out.println(map.get(max));
    System.out.println(max);
  }
}