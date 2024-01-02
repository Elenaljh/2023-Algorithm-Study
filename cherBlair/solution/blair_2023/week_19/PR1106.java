package blair_2023.week_19;

public class PR1106 {

    // 💛영어가 싫어요
    // https://school.programmers.co.kr/learn/courses/30/lessons/120894
    // 문제 설명
    // 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
    // 문자열 numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.

    // 제한사항
    //numbers는 소문자로만 구성되어 있습니다.
    //numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
    //1 ≤ numbers의 길이 ≤ 50
    //"zero"는 numbers의 맨 앞에 올 수 없습니다.

    class Solution {
        public long solution(String numbers) {
            String[] matchNumbers = {
                    "zero", "one", "two"
                    , "three", "four", "five"
                    , "six", "seven", "eight", "nine"};

            for (int i = 0; i < matchNumbers.length; i++) {
                numbers = numbers.replaceAll(matchNumbers[i], String.valueOf(i));
            }
            return Long.parseLong(numbers);
        }
    }

    // 다른 풀이 - [ hp ]
    // class Solution {
    //    public long solution(String numbers) {
    //        return Long.parseLong(
    //                numbers.replaceAll("zero", "0")
    //                        .replaceAll("one", "1")
    //                        .replaceAll("two", "2")
    //                        .replaceAll("three", "3")
    //                        .replaceAll("four", "4")
    //                        .replaceAll("five", "5")
    //                        .replaceAll("six", "6")
    //                        .replaceAll("seven", "7")
    //                        .replaceAll("eight", "8")
    //                        .replaceAll("nine", "9")
    //        );
    //    }
    //}
}
