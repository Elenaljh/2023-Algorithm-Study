package week_14;

import java.util.HashMap;
import java.util.Map;

public class PR1006 {

    // 모스부호
    // 문제 설명
    // 머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다.
    // 그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다.
    // 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
    // 모스부호는 다음과 같습니다.
    // morse = {
    //    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    //    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    //    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    //    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    //    '-.--':'y','--..':'z'
    //}

    // 제한사항
    //1 ≤ letter의 길이 ≤ 1,000
    //return값은 소문자입니다.
    //letter의 모스부호는 공백으로 나누어져 있습니다.
    //letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
    //해독할 수 없는 편지는 주어지지 않습니다.
    //편지의 시작과 끝에는 공백이 없습니다.

    class Solution {
        public String solution(String letter) {
            String answer = "";

            Map<String, String> morseMap = new HashMap<>() {
                {
                    put(".-", "a");
                    put("-...", "b");
                    put("-.-.", "c");
                    put("-..", "d");
                    put(".", "e");
                    put("..-.", "f");
                    put("--.", "g");
                    put("....", "h");
                    put("..", "i");
                    put(".---", "j");
                    put("-.-", "k");
                    put(".-..", "l");
                    put("--", "m");
                    put("-.", "n");
                    put("---", "o");
                    put(".--.", "p");
                    put("--.-", "q");
                    put(".-.", "r");
                    put("...", "s");
                    put("-", "t");
                    put("..-", "u");
                    put("...-", "v");
                    put(".--", "w");
                    put("-..-", "x");
                    put("-.--", "y");
                    put("--..", "z");
                }
            };

            String[] morseArray = letter.split(" ");

            for (String m : morseArray) {
                answer += morseMap.get(m);
            }
            return answer;
        }
    }

    // 다른 풀이 참고
    // import java.util.Arrays;
    //import java.util.HashMap;
    //import java.util.Map;
    //import java.util.stream.Collectors;
    //
    //class Solution {
    //    Map<String, String> dictionary = new HashMap<>() ;
    //
    //    public String solution(String letter) {
    //        return Arrays.stream(letter.split(" "))
    //            .map(dictionary::get)
    //            .collect(Collectors.joining());
    //    }
    //}
}
