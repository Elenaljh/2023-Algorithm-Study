import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> numbers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            numbers.add(kb.nextInt());
        }

        for (Integer integer : T.solution(num, numbers)) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> solution(int num,
                                  List<Integer> numbers) {

        List<Integer> result = new ArrayList<>();

        List<Integer> reversedNumbers = reversedNumbers(numbers);
        int maxNum = calculateMaxNum(reversedNumbers);
        boolean[] isSosu = new boolean[maxNum + 1];
        Arrays.fill(isSosu, true);
        isSosu[1] = false;

        for (int i = 2; i * i <= maxNum; i++) {
            for (int j = i * i; j <= maxNum; j += i) {
                isSosu[j] = false;
            }
        }

        for (int i = 0; i < reversedNumbers.size(); i++) {
            Integer targetNum = reversedNumbers.get(i);
            if (isSosu[targetNum]) {
                result.add(targetNum);
            }
        }

        return result;
    }

    private List<Integer> reversedNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            char[] cArr = String.valueOf(number).toCharArray();
            int length = cArr.length / 2;

            for (int i = 0; i < length; i++) {
                int iLength = cArr.length - i - 1;
                char tempC = cArr[i];
                cArr[i] = cArr[iLength];
                cArr[iLength] = tempC;
            }

            result.add(Integer.parseInt(new String(cArr)));
        }

        return result;
    }

    private int calculateMaxNum(Collection<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
    }
}