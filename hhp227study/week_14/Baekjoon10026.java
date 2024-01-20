import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] rgbArray = initRGBArray(n, scanner);
        String[] rbArray = initRBArray(rgbArray);

        System.out.println(getInvokeCount(rgbArray) + " " + getInvokeCount(rbArray));
        scanner.close();
    }

    public static int getInvokeCount(String[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].charAt(j) != 'E') {
                    count++;
                    bfs(new int[] {i, j}, array[i].charAt(j), array);
                }
            }
        }
        return count;
    }

    public static void bfs(int[] start, char character, String[] array) {
        Queue<int[]> queue = new LinkedList<>(List.of(start));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] direction : new int[][] {{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}}) {
                int nextI = direction[0];
                int nextJ = direction[1];

                if (array[nextI].charAt(nextJ) == character) {
                    array[nextI] = array[nextI].substring(0, nextJ) + "E" + array[nextI].substring(nextJ + 1);

                    queue.offer(direction);
                }
            }
        }
    }

    public static String[] initRGBArray(int n, Scanner scanner) {
        String[] array = new String[n + 2];
        array[0] = "E".repeat(n + 2);

        for (int i = 1; i <= n; i++) {
            array[i] = "E" + scanner.next() + "E";
        }
        array[n + 1] = "E".repeat(n + 2);
        return array;
    }

    public static String[] initRBArray(String[] array) {
        String[] result = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            char[] charArray = array[i].toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == 'G') {
                    charArray[j] = 'R';
                }
            }
            result[i] = new String(charArray);
        }
        return result;
    }
}
