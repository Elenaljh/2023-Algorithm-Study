/**
평균
https://www.acmicpc.net/problem/1546
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		    Scanner input = new Scanner(System.in);
		    String num = input.nextLine();
		    String subject = input.nextLine();
		    String[] array = subject.split(" ");
		    float sum = 0;
		    int M = 0;
		
		    for (int i = 0; i < array.length; i++) {
			      M = Math.max(M, Integer.parseInt(array[i]));
		    }
		    for (int i = 0; i < array.length; i++) {
			      sum += Float.parseFloat(array[i]) / M * 100;
		    }
		    DecimalFormat df = new DecimalFormat(".00");
		    System.out.println(df.format(sum / Integer.parseInt(num)));
	  }
}
