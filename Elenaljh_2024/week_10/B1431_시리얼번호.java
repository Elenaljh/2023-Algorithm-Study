import java.util.*;
import java.io.*;
public class B1431_시리얼번호 {
    static class SerialNumber implements Comparable<SerialNumber> {
        String number;
        int length;
        int sum;

        public SerialNumber(String number) {
            this.number = number;
            this.length = number.length();
            this.sum = sumOfNumber();
        }

        int sumOfNumber(){
            String str = this.number;
            int cnt =0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c-'0' >= 0 && c-'0' <= 9) cnt += c-'0';
            }
            return cnt;
        }

        @Override
        public int compareTo(SerialNumber o) {
            if (this.length == o.length && this.sum == o.sum) {
                return this.number.compareTo(o.number);
            } else if (this.length == o.length) {
                return this.sum - o.sum;
            } else {
                return this.length - o.length;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SerialNumber[] arr = new SerialNumber[N];
        for (int i= 0; i < N; i++) {
            arr[i] = new SerialNumber(br.readLine());
        }
        Arrays.sort(arr);
        for (int i =0; i < N; i++) {
            System.out.println(arr[i].number);
        }
    }
}
